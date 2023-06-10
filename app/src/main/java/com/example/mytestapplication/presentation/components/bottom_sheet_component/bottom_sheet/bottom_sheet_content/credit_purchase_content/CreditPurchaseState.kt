package com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.credit_purchase_content

import java.time.OffsetDateTime


data class BtsCreditPurchaseState(
    val date: OffsetDateTime = OffsetDateTime.now(),
    val amount: String = "0.00",
    val description: String = "",
    /**
     * to format an empty string to fit in the Int type. to resolve for the
     * case when we delete the text in the "quantity outlined textbox"
     * in such a way as to have a blank text. how would it convert to
     * Int as required to update its cashSaleState? that is why we return 0
     * if text is blank requiring a lambda instead of just
     * "val quantity: Int" we have "val quantity: () -> Int"
     */
    val quantity: String = "0",
    val name: String = "",
    val lenderName: String =""

){
    fun compressedDate(): String {
        return "${date.dayOfMonth} -${date.month}-${date.year}"
    }
    fun returnToDefault(): BtsCreditPurchaseState {
        return BtsCreditPurchaseState(
            date = OffsetDateTime.now(),
            amount = "0.00",
            description = "",
            quantity = "0",
            name = "",
            lenderName = ""
        )

    }
}
