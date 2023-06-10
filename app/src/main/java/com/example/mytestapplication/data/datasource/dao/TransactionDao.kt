package com.example.mytestapplication.data.datasource.dao
import androidx.room.*
import com.example.mytestapplication.data.datasource.entity.Account
import kotlinx.coroutines.flow.Flow
/*
@Dao
interface TransactionDao {

    @Query("SELECT * FROM `transaction`")
    fun getTransactions(): Flow<List<com.example.mytestapplication.data.datasource.entity.Transaction>>

    @Query("SELECT * FROM `transaction` WHERE id = :id")
    suspend fun getTransactionById(id: Int): com.example.mytestapplication.data.datasource.entity.Transaction?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: com.example.mytestapplication.data.datasource.entity.Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: com.example.mytestapplication.data.datasource.entity.Transaction)
}*/