package com.example.mytestapplication.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.focus.FocusState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytestapplication.data.datasource.entity.Account
import com.example.mytestapplication.domain.model.SearchBoxState
import com.example.mytestapplication.domain.use_case.account_usecase.UseCases
import com.example.mytestapplication.presentation.components.homepage.home_page_components.search_functionality.SortState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AccountViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    init {
        getAccounts()
    }
    private val _accounts = MutableStateFlow<List<Account>>(emptyList())
    val accounts = _accounts.asStateFlow()

    private var accountJob: Job? = null

    private val _recentItems = _accounts.map { account ->
        account.filter { it.dateOfItemRecentClick != null }
            .sortedByDescending { it.dateOfItemRecentClick }
    }
    val recentItems = _recentItems


     private var _searchBoxState = mutableStateOf(
        SearchBoxState(
            isHintVisible = true,
            hint = "search",
            text = MutableStateFlow("")
        )
    )
    val searchBoxState = _searchBoxState

    private var _searchBoxText = _searchBoxState.value.text
    val searchBoxText = _searchBoxText.asStateFlow()

    var searchedText = accounts.combine(searchBoxText) { account, text ->

        if (text.isBlank()) {
            emptyList()
        } else {
            account.filter { it.doesMatchQuery(text) }
        }

    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        _accounts.value
    )

    fun changeFocusState(state: FocusState) {
        _searchBoxState.value = _searchBoxState.value.copy(
            isHintVisible = !state.hasFocus && _searchBoxState.value.text.value.isBlank(),
        )

    }

    fun filterItem(query: SortState){
        viewModelScope.launch {

             _accounts.value =  when(query){
                   is SortState.Date -> { _accounts.value.sortedByDescending { it.date  }}
                   is SortState.ActiveState -> { _accounts.value.sortedByDescending { it.isActive  }}
                   is SortState.Ascending -> { _accounts.value.sortedBy { it.name  }}
                   is SortState.Descending -> { _accounts.value.sortedByDescending { it.name  }}
               }

            }
       }


    fun searchBoxTextChange(text: String) {
        _searchBoxText.value  = text

    }


    private fun getAccounts() {

        accountJob?.cancel()
        accountJob = useCases.getAccounts()
            .onEach { account ->
                _accounts.value = account
            }.launchIn(viewModelScope)
    }


    /** i called this function, inserting account, automatically updating
     * value for my _accounts. how is this  possible? since the only time
     * i call getAccounts - the function charged with the responsibility
     * of updating _accounts is only during initializing. if after i call
     * insertAccount it restarts viewmodel and recalls init block, then it
     * will make sense - though it will feel non optimal. but it doesn't!.
     *
     * study more on ".value" property of flows, it might be what is keeping
     * it aware of changes and also on cancellation of coroutines
     * *
     */
    fun insertAccount(account: Account) {
        viewModelScope.launch {
            useCases.insertAccount(account)
        }
    }

    fun deleteAccount(account: Account) {
        viewModelScope.launch {
            useCases.deleteAccount(account)

        }
    }

}


