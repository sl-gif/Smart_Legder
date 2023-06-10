package com.example.mytestapplication.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytestapplication.data.datasource.entity.Account
import com.example.mytestapplication.data.datasource.entity.AccountWithTransaction
import com.example.mytestapplication.data.datasource.entity.Transaction
import com.example.mytestapplication.domain.use_case.account_usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.OffsetDateTime
import javax.inject.Inject

@HiltViewModel
class AccountDetailViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val _transactions = mutableStateOf<List<AccountWithTransaction>>(emptyList())
   val transaction = _transactions



    private var transactionJob: Job? = null

    private var _id  = savedStateHandle.get<Int>("userId")!!
    val id = _id

    init{

        viewModelScope.launch {

            getTransactions(_id)
            val owner = useCases.getAccount(_id)

            Log.d("OwnerIdddd","${owner!!.userId}")
            Log.d("transactionnnn viewmodel","$_transactions")

            if (owner != null) {
               useCases.updateAccount(
                    Account(
                        name = owner.name ,
                        dateOfItemRecentClick = OffsetDateTime.now(),
                        date = owner.date,
                        userId = owner.userId,
                        isActive = owner.isActive,
                    )
                )
            }
        }
    }

    fun getTransactions(userId: Int) {
        transactionJob?.cancel()
      transactionJob = viewModelScope.launch {
           useCases.getAccountWithTransactions(userId).onEach { value ->
               _transactions.value = value
           }.launchIn(viewModelScope)
       }
   }

    fun insertTransaction( transaction: Transaction){
        viewModelScope.launch {
            useCases.insertTransaction(transaction)
        }

    }

}