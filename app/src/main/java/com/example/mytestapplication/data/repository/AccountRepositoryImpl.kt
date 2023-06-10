package com.example.mytestapplication.data.repository

import android.util.Log
import com.example.mytestapplication.data.datasource.dao.AccountDao
import com.example.mytestapplication.data.datasource.entity.Account
import com.example.mytestapplication.data.datasource.entity.AccountWithTransaction
import com.example.mytestapplication.data.datasource.entity.Transaction
import com.example.mytestapplication.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow

class AccountRepositoryImpl (private val accountDao: AccountDao) : AccountRepository {
    override fun getAccounts(): Flow<List<Account>> {
         return accountDao.getAccounts()
    }

    override suspend fun getAccountById(id: Int): Account? {
      return accountDao.getAccountById(id)
    }

    override suspend fun getRecentAccount(limit: Int, offset: Int): List<Account?> {
        return emptyList()
       // return //accountDao.getRecentAccount(limit,offset)
    }

    override suspend fun insertAccount(account: Account) {
        Log.d("repoinsert","log has inserted")
        accountDao.insertAccount(account)
    }

    override suspend fun updateAccount(account: Account) {
        accountDao.updateAccount(account)
    }

    override suspend fun deleteAccount(account: Account) {
        accountDao.deleteAccount(account)
    }

    override suspend fun getAccountAndTransactions(userId: Int): Flow<List<AccountWithTransaction>> {
       return accountDao.getAccountAndTransactions(userId)
    }

  //  override fun getTransactions(): Flow<List<Transaction>> {

  //  }

    override suspend fun getTransactionById(id: Int): Transaction? {
        TODO("Not yet implemented")
    }

    override suspend fun insertTransaction(transaction: Transaction) {
        accountDao.insertTransaction(transaction)
    }

    override suspend fun deleteTransaction(transaction: Transaction) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllTransactions(): Flow<List<Transaction>> {
       return accountDao.getTransactions()
    }
}