package com.example.mytestapplication.domain.use_case.account_usecase

import com.example.mytestapplication.data.datasource.entity.Account
import com.example.mytestapplication.domain.repository.AccountRepository
import javax.inject.Inject

class InsertAccount @Inject constructor(
    private val accountRepository: AccountRepository
) {

    suspend operator fun invoke(account: Account){
        if(account.name.isBlank()){
            return
        }
        accountRepository.insertAccount(account)
    }
}