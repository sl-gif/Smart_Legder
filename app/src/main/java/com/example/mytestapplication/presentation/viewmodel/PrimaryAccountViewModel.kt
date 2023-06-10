package com.example.mytestapplication.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytestapplication.data.datasource.entity.Transaction
import com.example.mytestapplication.domain.use_case.account_usecase.UseCases
import com.example.mytestapplication.presentation.components.homepage.home_page_components.primary_account_package.PrimaryAccountType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * i have created another viewModel apart from accountViewModel and AccountDetailViewModel
 * to serve solely and exclusively for querying all transaction respectively
 * for the primaryAccountDetails
 * i could not use accountViewModel as that viewModel has its exclusive responsibility
 * of handling accounts and AccountDetailViewModel queries transaction
 * data for a particular account clicked hence its getTransactionById
 * that is called in initialization
 */
@HiltViewModel
class PrimaryAccountViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
    ) : ViewModel() {
    private val type = savedStateHandle.get<PrimaryAccountType>("id")

    private val _allTransactions = MutableStateFlow<List<Transaction>>(emptyList())
    val allTransaction = _allTransactions.map{
        it.filter { transaction ->

            when(type){
                PrimaryAccountType.CASH ->{ transaction.type == "cash sale"}
                PrimaryAccountType.DEBT ->{transaction.type == "credit purchase"}
                PrimaryAccountType.CREDIT ->{ transaction.type == "credit sale"}
                PrimaryAccountType.SAVINGS ->{transaction.type == "cash sale"}
                else -> {
                    false
                }
            }
        }

    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        emptyList()
    )

    init {

        getAllTransaction()
        Log.d("initialized viewmodel","this viewmodel is init by $type")
    }

    private fun getAllTransaction() {
        viewModelScope.launch {

         val v = useCases.getAllTransactions(){}.firstOrNull()

            if (v != null) {
                _allTransactions.value = v
            }

        }
    }

    override fun onCleared() {
        Log.d("oncleared","this viewmodel has been cleared with acc ${allTransaction.value}")
    }
}

