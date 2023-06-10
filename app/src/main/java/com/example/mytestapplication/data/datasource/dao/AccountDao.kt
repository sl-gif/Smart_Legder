package com.example.mytestapplication.data.datasource.dao

import android.util.Log
import androidx.room.*
import com.example.mytestapplication.data.datasource.entity.Account
import com.example.mytestapplication.data.datasource.entity.AccountWithTransaction
import com.example.mytestapplication.data.datasource.entity.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {

    @Query("SELECT * FROM `account`")
    fun getAccounts(): Flow<List<Account>>

    @Query("SELECT * FROM `account` WHERE userId = :id")
    suspend fun getAccountById(id: Int): Account?

  //  @Query("SELECT * FROM `account` ORDER BY date LIMIT :limit OFFSET :offset")
 //   suspend fun getRecentAccount(limit: Int, offset: Int): List<Account?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(account: Account)

    @Update
    suspend fun updateAccount(account: Account)

    @Delete
    suspend fun deleteAccount(account: Account)

    @androidx.room.Transaction
    @Query("SELECT * FROM `account` where userId = :userId")
    fun getAccountAndTransactions(userId: Int): Flow<List<AccountWithTransaction>>

    @Query("SELECT * FROM `transaction`")
    fun getTransactions(): Flow<List<Transaction>>

    @Query("SELECT * FROM `transaction` WHERE transactionId = :id")
    suspend fun getTransactionById(id: Int): Transaction?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)
}

