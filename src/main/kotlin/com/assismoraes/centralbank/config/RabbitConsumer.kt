package com.assismoraes.centralbank.config

import com.assismoraes.centralbank.dto.TransactionRabbitMessageDto
import com.assismoraes.centralbank.services.TransactionService
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class RabbitConsumer(
    private var transactionService: TransactionService
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @RabbitListener(queues = ["transactions-to-cb"])
    fun receiveTransactionMessage(message: TransactionRabbitMessageDto) {
        transactionService.saveTransactionData(message)
    }

}