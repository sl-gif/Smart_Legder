package com.example.mytestapplication.di

import android.app.Application
import androidx.room.Room
import com.example.mytestapplication.data.datasource.database.AccountDatabase
import com.example.mytestapplication.data.repository.AccountRepositoryImpl
import com.example.mytestapplication.domain.repository.AccountRepository
import com.example.mytestapplication.domain.use_case.*
import com.example.mytestapplication.domain.use_case.account_usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesAccountDatabase(app: Application): AccountDatabase{
       return Room.databaseBuilder(
           app,
           AccountDatabase::class.java,
           AccountDatabase.DATABASE_NAME
       )
           .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun providesAccountRepository(database: AccountDatabase): AccountRepository {
        return AccountRepositoryImpl(database.dao)
    }

    @Provides
    @Singleton
    fun providesUseCases(accountRepository: AccountRepository): UseCases {
        return UseCases(
           deleteAccount = DeleteAccount(accountRepository),
            getAccounts = GetAccounts(accountRepository),
            insertAccount = InsertAccount(accountRepository),
            getAccountWithTransactions = GetAccountWithTransactions(accountRepository),
            insertTransaction = InsertTransaction(accountRepository),
            getRecentAccounts = GetRecentAccounts(accountRepository),
            getAllTransactions = GetAllTransaction(accountRepository),
            getAccount = GetAccount(accountRepository),
            updateAccount = UpdateAccount(accountRepository)
        )
    }


}