package com.example.mytestapplication.presentation.components.homepage.home_page_components.account_component

import com.example.mytestapplication.data.datasource.entity.Account


data class AccountState(
    val account: List<Account>,
    val recentAccount:  List<Account>,
    val searchBoxText: String
)