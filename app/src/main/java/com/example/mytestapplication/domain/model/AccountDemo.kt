package com.example.mytestapplication.domain.model

import androidx.compose.ui.graphics.painter.Painter

data class AccountDemo(
    val user: String,
    val isActive: Boolean,
    val active: ()-> Unit,
    val image: Painter
)

enum class USERSTATE{
    ACTIVE,
    INACTIVE

}
