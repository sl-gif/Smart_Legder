package com.example.mytestapplication.presentation.components.bottom_sheet_component.components

import com.example.mytestapplication.data.datasource.entity.FinancialData

sealed class InsertType{
    data class CreditSaleInsert(
        val financialData: FinancialData
    ) : InsertType()
    data class CashSaleInsert(
        val financialData: FinancialData
    ) : InsertType()
    data class CreditPurchaseInsert(
        val financialData: FinancialData
    ) : InsertType()
    data class CashPurchaseInsert(
        val financialData: FinancialData
    ) : InsertType()

    data class Account(
        val financialData: FinancialData
    ): InsertType()

}
