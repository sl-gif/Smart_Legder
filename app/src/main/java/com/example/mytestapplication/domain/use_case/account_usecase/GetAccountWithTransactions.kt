package com.example.mytestapplication.domain.use_case.account_usecase

import com.example.mytestapplication.data.datasource.entity.AccountWithTransaction
import com.example.mytestapplication.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow

class GetAccountWithTransactions(
    private val accountRepository: AccountRepository
    )
{
    suspend operator fun invoke(userId: Int): Flow<List<AccountWithTransaction>> {
       return accountRepository.getAccountAndTransactions(userId)
    }
}