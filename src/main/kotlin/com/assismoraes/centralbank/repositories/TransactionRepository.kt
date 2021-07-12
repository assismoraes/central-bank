package com.assismoraes.centralbank.repositories

import com.assismoraes.centralbank.models.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<Transaction, Long> {
}