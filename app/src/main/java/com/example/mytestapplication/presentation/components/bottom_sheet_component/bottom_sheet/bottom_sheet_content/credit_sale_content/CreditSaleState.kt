package com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.credit_sale_content

import java.time.OffsetDateTime


data class BtsCreditSaleState(
    val date: OffsetDateTime = OffsetDateTime.now(),
    val amount: String = "0.00",
    val description: String = "",
    val quantity: String = "0",
    val name: String = "",
    val borrowerName: String = ""

){
    fun compressedDate(): String {
        return "${date.dayOfMonth} -${date.month}-${date.year}"
    }

    fun returnToDefault(): BtsCreditSaleState {
        return BtsCreditSaleState(
            date = OffsetDateTime.now(),
            amount = "0.00",
            description = "",
            quantity = "0",
            name = "",
            borrowerName = ""
        )

    }
}
