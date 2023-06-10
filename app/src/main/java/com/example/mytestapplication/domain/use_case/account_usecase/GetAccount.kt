package com.example.mytestapplication.domain.use_case.account_usecase

import com.example.mytestapplication.data.datasource.entity.Account
import com.example.mytestapplication.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAccount @Inject constructor(
private val accountRepository: AccountRepository
) {

    suspend operator fun invoke(userId: Int): Account? {
        return accountRepository.getAccountById(userId)
    }
}