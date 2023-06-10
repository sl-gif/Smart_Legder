package com.example.mytestapplication.domain.use_case.account_usecase

data class UseCases(
    val deleteAccount: DeleteAccount,
    val getAccounts: GetAccounts,
    val insertAccount: InsertAccount,
    val getAccountWithTransactions: GetAccountWithTransactions,
    val insertTransaction: InsertTransaction,
    val getRecentAccounts: GetRecentAccounts,
    val getAllTransactions: GetAllTransaction,
    val getAccount: GetAccount,
    val updateAccount: UpdateAccount
)
