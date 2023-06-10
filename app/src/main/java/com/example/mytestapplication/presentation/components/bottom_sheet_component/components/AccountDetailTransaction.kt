package com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.util.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mytestapplication.data.datasource.entity.Transaction

@Composable
fun AccountDetailTransaction (
    transactions: Transaction
){
    Card(
        modifier = Modifier
            .padding(5.dp)
            .height(70.dp),
        colors = CardDefaults.cardColors(Color.White)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,


            ) {
            Text(
                transactions.nameOfProduct
                ,color = Color.Black,
                style = MaterialTheme.typography.bodyMedium
            )

            IconButton(
                onClick = {  },
                modifier = Modifier
                    .align(Alignment.Bottom)
            ) {
                Icon(imageVector = Icons.Default.Delete,
                    contentDescription = "delete_note",
                    tint = MaterialTheme.colorScheme.secondary

                )


            }

        }
    }
    Spacer(modifier = Modifier.padding(4.dp))

}