package com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.cash_sale_content

import java.time.OffsetDateTime


data class BtsCashSaleState(
    val date: OffsetDateTime,
    val amount: String,
    val description: String,
    val quantity: String,
    val name: String,



    ){
    fun compressedDate(): String {
        return "${date.dayOfMonth} -${date.month}-${date.year}"
    }


    fun returnToDefault(): BtsCashSaleState {
        return BtsCashSaleState(
            date = OffsetDateTime.now(),
            amount = "0.00",
            description = "",
            quantity = "0",
            name = ""
        )

    }
}

