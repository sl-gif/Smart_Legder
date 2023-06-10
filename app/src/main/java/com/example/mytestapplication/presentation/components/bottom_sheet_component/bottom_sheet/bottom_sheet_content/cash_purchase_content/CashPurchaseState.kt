package com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.cash_purchase_content

import java.time.OffsetDateTime


data class BtsCashPurchaseState(
    val date: OffsetDateTime = OffsetDateTime.now(),
    val amount: String = "0.00",
    val description: String = "",
    val quantity: String = "0",
    val name: String = ""

){
    fun compressedDate(): String {
        return "${date.dayOfMonth} -${date.month}-${date.year}"
    }

    fun returnToDefault(): BtsCashPurchaseState {
        return BtsCashPurchaseState(
            date = OffsetDateTime.now(),
            amount = "0.00",
            description = "",
            quantity = "0",
            name = ""
        )

    }
}