package com.example.mytestapplication.domain.use_case.account_usecase

import com.example.mytestapplication.data.datasource.entity.Account
import com.example.mytestapplication.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecentAccounts constructor(
        private val accountRepository: AccountRepository
    ) {

        suspend operator fun invoke(limit: Int, offset: Int): List<Account?> {
            return accountRepository.getRecentAccount(limit,offset)
        }
    }