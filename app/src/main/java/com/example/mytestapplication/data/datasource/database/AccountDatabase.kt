package com.example.mytestapplication.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mytestapplication.data.datasource.dao.AccountDao
import com.example.mytestapplication.data.datasource.entity.Account
import com.example.mytestapplication.data.datasource.entity.Transaction
import com.example.mytestapplication.domain.model.TimeConverter

@Database(
   entities = [Account::class,Transaction::class],
   version = 25
)
@TypeConverters(TimeConverter::class)
abstract class AccountDatabase : RoomDatabase() {

   abstract val dao: AccountDao

   companion object{
      const val DATABASE_NAME = "accounts_db"
   }

}