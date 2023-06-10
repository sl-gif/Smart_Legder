package com.example.mytestapplication.domain.use_case.account_usecase

import com.example.mytestapplication.data.datasource.entity.Transaction
import com.example.mytestapplication.domain.repository.AccountRepository
import javax.inject.Inject

class InsertTransaction@Inject constructor(
    private val accountRepository: AccountRepository
) {

    suspend operator fun invoke(transaction: Transaction){
        accountRepository.insertTransaction(transaction)

    }
}