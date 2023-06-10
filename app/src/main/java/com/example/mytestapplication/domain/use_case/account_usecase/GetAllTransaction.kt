package com.example.mytestapplication.domain.use_case.account_usecase

import android.util.Log
import com.example.mytestapplication.data.datasource.entity.Transaction
import com.example.mytestapplication.domain.repository.AccountRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class GetAllTransaction @Inject constructor(
    private val accountRepository: AccountRepository
    ) {

    suspend operator fun invoke( printData: suspend (data: List<Transaction>)->Unit): Flow<List<Transaction>> {
        val data = accountRepository.getAllTransactions()
        Log.d("first pass","this is first pass")
        data.onEach {
            printData(it)
            Log.d("second pass","this is second pass")


        }
        return data
    }
}