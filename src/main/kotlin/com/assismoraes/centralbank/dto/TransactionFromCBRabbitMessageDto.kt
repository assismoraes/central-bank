package com.assismoraes.centralbank.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class TransactionFromCBRabbitMessageDto(
    @JsonProperty("centralBankCode") val centralBankCode: String,
    @JsonProperty("bankCode") val bankCode: String
) : Serializable {

}