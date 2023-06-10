package com.example.mytestapplication.domain.use_case.transaction_usecase

import com.example.mytestapplication.data.datasource.entity.Transaction
import com.example.mytestapplication.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class GetTransactions @Inject constructor(
    private val transactionRepository: TransactionRepository
) {

    operator fun invoke(): Flow<List<Transaction>>{
      return  transactionRepository.getTransactions().onEach { it ->
            it.sortedBy { it.time }
        }


    }
}