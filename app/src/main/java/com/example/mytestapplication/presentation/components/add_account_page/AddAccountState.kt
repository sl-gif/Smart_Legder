package com.example.mytestapplication.presentation.components.add_account_page

import java.time.OffsetDateTime


data class AddAccountTextState(
    val name: String,
    val isActive: Boolean,
    private val date: OffsetDateTime,
    val isSubmitted: Boolean
){

    fun customisedDate(): String {
        return "${date.dayOfMonth} -${date.month}-${date.year}"
    }
}