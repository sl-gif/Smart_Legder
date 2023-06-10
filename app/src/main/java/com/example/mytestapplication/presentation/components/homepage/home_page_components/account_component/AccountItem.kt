package com.example.mytestapplication.presentation.components.homepage.home_page_components.account_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mytestapplication.R
import com.example.mytestapplication.core.ImageItemWithName
import com.example.mytestapplication.core.ImageItemWithoutName
import com.example.mytestapplication.data.datasource.entity.Account

@Composable
fun AccountItem(
    modifier: Modifier = Modifier,
    account: Account,
    onClick: () -> Unit,
    onDeleteClick: () -> Unit
){
    Card(
        modifier = modifier
            .clickable { onClick() }
            .padding(5.dp)
            .shadow(2.dp, RoundedCornerShape(10.dp))
            .height(70.dp),
        colors = CardDefaults.cardColors(Color.White)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(0.7f)
            ){
                   ImageItemWithoutName(
                       modifier = Modifier
                           .padding(end = 10.dp)
                           .fillMaxHeight()
                           .width(50.dp)
                       ,
                       painter = painterResource(id = R.drawable.ic_launcher_foreground))

                Column() {
                    Text(
                        text = account.name,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )

                    Text(
                        text = if(account.isActive) "active" else "inactive",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.LightGray
                    )
                }
            }

            IconButton(
                onClick = { onDeleteClick() },
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
    Spacer(modifier = Modifier.padding(8.dp))

}
