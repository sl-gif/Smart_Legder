package com.example.mytestapplication.domain.repository

import com.example.mytestapplication.data.datasource.entity.Account
import com.example.mytestapplication.data.datasource.entity.AccountWithTransaction
import com.example.mytestapplication.data.datasource.entity.Transaction
import kotlinx.coroutines.flow.Flow

interface AccountRepository {

    fun getAccounts(): Flow<List<Account>>

    suspend fun getAccountById(id: Int): Account?

    suspend fun getRecentAccount(limit: Int, offset: Int): List<Account?>


    suspend fun insertAccount(account: Account)

    suspend fun updateAccount(account: Account)

    suspend fun deleteAccount(account: Account)

    suspend fun getAccountAndTransactions(userId: Int): Flow<List<AccountWithTransaction>>

    //transactions


   // fun getTransactions(): Flow<List<Transaction>>

    suspend fun getTransactionById(id: Int): Transaction?

    suspend fun insertTransaction(transaction: Transaction)

    suspend fun deleteTransaction(transaction: Transaction)

    suspend fun getAllTransactions(): Flow<List<Transaction>>


}