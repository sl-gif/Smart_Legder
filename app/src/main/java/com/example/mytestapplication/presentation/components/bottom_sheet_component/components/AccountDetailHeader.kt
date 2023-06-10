package com.example.mytestapplication.presentation.components.bottom_sheet_component.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Details
import androidx.compose.material.icons.filled.Money
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.mytestapplication.presentation.components.homepage.home_page_components.primary_account_package.PrimaryAccountItem
import com.example.mytestapplication.presentation.components.homepage.home_page_components.primary_account_package.PrimaryAccountType

data class AccountDetailHeaderData(
    val accountType: PrimaryAccountType,
    val icon: ImageVector

)
val icons =  listOf(
   Icons.Default.Money,
    Icons.Default.Details,
    Icons.Default.AccountTree,
    Icons.Default.AccountBox,
)

val accountDetailsHeadersTitle = listOf(
    AccountDetailHeaderData(
        accountType = PrimaryAccountType.CASH,
        icon = icons[0]
    ),
    AccountDetailHeaderData(
        accountType = PrimaryAccountType.CREDIT,
        icon = icons[1]
    ),
    AccountDetailHeaderData(
        accountType = PrimaryAccountType.DEBT,
        icon = icons[2]
    ),
    AccountDetailHeaderData(
        accountType = PrimaryAccountType.SAVINGS,
        icon = icons[3]
    ),
)


@Composable fun AccountDetailHeader(
    image: Painter
){
   Column(
       modifier = Modifier.fillMaxWidth(),
       verticalArrangement = Arrangement.SpaceBetween,
       horizontalAlignment = Alignment.CenterHorizontally
   ){
      // Image(painter = image, contentDescription = null)
     //  ImageItemWithName()
       Row(modifier = Modifier
           .fillMaxWidth()
           .height(100.dp),
           horizontalArrangement = Arrangement.SpaceEvenly,
           verticalAlignment = Alignment.CenterVertically
       ) {
           repeat(4) { index ->
               PrimaryAccountItem(
                   modifier = Modifier
                       .height(80.dp)
                       .width(80.dp),
                   imageVector = accountDetailsHeadersTitle[index].icon,
                   type = accountDetailsHeadersTitle[index].accountType
               ) {}
               Spacer(
                   modifier = Modifier
                       .width(8.dp)
                       .background(Color.Green)
               )
           }
       }
   }
}