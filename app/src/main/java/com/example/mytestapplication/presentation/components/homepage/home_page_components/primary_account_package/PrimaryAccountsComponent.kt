package com.example.mytestapplication.presentation.components.homepage.home_page_components.primary_account_package

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Money
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import java.util.*



@Composable
fun PrimaryAccountComponent(
    onClick: (navArg: PrimaryAccountType) -> Unit
){


    Row(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){

       repeat(PrimaryAccountType.values().size){
            PrimaryAccountItem(modifier = Modifier
                .height(80.dp)
                .width(80.dp),
                imageVector = Icons.Default.Money ,
                type = PrimaryAccountType.values()[it],
                onClick = onClick
            )
           Spacer(modifier = Modifier
                .width(8.dp)
                .background(Color.Green))

       }

    }

}

@Composable fun PrimaryAccountItem(
    modifier: Modifier,
    imageVector: ImageVector,
    type: PrimaryAccountType,
    onClick: (navArg: PrimaryAccountType) -> Unit
){
    Column(modifier,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){

        IconButton(onClick = {
            onClick(type)
            Log.d("iconButton","clicked")

        }) {
            Icon(imageVector = imageVector, contentDescription = null ,tint = MaterialTheme.colorScheme.secondary)
        }

            Text(
                text = type.name.lowercase(Locale.ROOT),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black
            )

    }
}