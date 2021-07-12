package com.assismoraes.centralbank.models

import com.assismoraes.centralbank.enums.TransactionType
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var bankCode: String,

    @field:NotNull
    var value: Long,

    @Enumerated(EnumType.STRING)
    var type: TransactionType,

    var date: Date

) {
    var centralBankCode: String = ""

    init {
        centralBankCode = UUID.randomUUID().toString()
    }
}