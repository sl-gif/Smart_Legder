package com.example.mytestapplication.presentation.components.primary_account_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mytestapplication.data.datasource.entity.Transaction
import com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.util.components.AccountDetailTransaction

@Composable
fun PrimaryAccountDetails(
    state: List<Transaction>
){

    LazyColumn{
        item {
            Card(modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .background(Color.LightGray)
            ) {
                Text("You have Made Total Sales of 10,000")
            }
        }
        items(state){
           AccountDetailTransaction(transactions = it )
        }
    }
}