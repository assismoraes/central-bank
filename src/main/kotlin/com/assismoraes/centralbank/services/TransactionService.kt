package com.assismoraes.centralbank.services

import com.assismoraes.centralbank.dto.TransactionFromCBRabbitMessageDto
import com.assismoraes.centralbank.dto.TransactionRabbitMessageDto
import com.assismoraes.centralbank.models.Transaction
import com.assismoraes.centralbank.repositories.TransactionRepository
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TransactionService(
    private val repository: TransactionRepository,
    private val rabbitTemplate: RabbitTemplate
) {
    @Transactional
    fun saveTransactionData(tDto: TransactionRabbitMessageDto) {
        val transaction = Transaction(
            bankCode = tDto.bankCode,
            value = tDto.value,
            type = tDto.type,
            date = tDto.date
        )

        repository.save(transaction)

        val message = TransactionFromCBRabbitMessageDto(
            centralBankCode = transaction.centralBankCode,
            bankCode = transaction.bankCode
        )

        rabbitTemplate.convertAndSend("bank.transaction-from-cb", "rq-transactions-from-cb", message)
    }

}