package com.example.mytestapplication.domain.repository

import com.example.mytestapplication.data.datasource.entity.Account
import com.example.mytestapplication.data.datasource.entity.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {

    fun getTransactions(): Flow<List<Transaction>>

    suspend fun getTransactionById(id: Int): Transaction?

    suspend fun insertTransaction(transaction: Transaction)

    suspend fun deleteTransaction(transaction: Transaction)
}