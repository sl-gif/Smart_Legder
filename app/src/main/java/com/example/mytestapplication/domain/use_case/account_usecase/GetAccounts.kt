package com.example.mytestapplication.domain.use_case.account_usecase

import com.example.mytestapplication.data.datasource.entity.Account
import com.example.mytestapplication.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAccounts @Inject constructor(
    private val accountRepository: AccountRepository
) {

    operator fun invoke(): Flow<List<Account>> {
       return accountRepository.getAccounts().map { account -> account.sortedByDescending { it.date } }
    }
}