package com.example.mytestapplication.domain.model

import kotlinx.coroutines.flow.MutableStateFlow

data class SearchBoxState(
    val isHintVisible: Boolean ,
    val hint: String,
    var text: MutableStateFlow<String> ,
  //  val onTextChanged: () -> Unit
)
