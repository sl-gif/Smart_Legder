package com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mytestapplication.core.ImageItemWithName
import com.example.mytestapplication.data.datasource.entity.AccountWithTransaction


@Composable
fun AccountDetailPage(
    transactions: List<AccountWithTransaction>,
    name: String
) {

    LazyColumn(Modifier.padding(start = 8.dp, end = 8.dp).background(Color(0xFFf2fdff))){
        item {
            ImageItemWithName(name = name, textStyle = MaterialTheme.typography.body1)


        }
        item{
            Spacer(modifier = Modifier.height(16.dp))
        }
        if (transactions.isNotEmpty()) {
            // items(transactions[0].transaction) { list ->
            items(transactions[0].transaction.size) { index ->
                Column {

                    if (index == 0) {
                        Text(
                            text="${transactions[0].transaction[index].time} hhhh",
                            color = Color.Black

                        )

                    }
                    AccountDetailTransaction(transactions[0].transaction[index])
                }
            }
        }
    }
}


