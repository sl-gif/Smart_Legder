package com.example.mytestapplication.presentation.components.homepage.home_page_components.recent_account_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mytestapplication.core.ImageItemWithName
import com.example.mytestapplication.data.datasource.entity.Account

@Composable
fun RecentItemComponent(
    navController: NavController,
    recentAccounts: List<Account>,
    modifier: Modifier = Modifier
){
    Column(
    modifier = modifier.fillMaxWidth()
    ) {
        Text(text = "Recent",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        modifier = Modifier.padding(16.dp))
        LazyRow{
            items(recentAccounts){ recentAccount ->
                RecentItem(
                    account = recentAccount,
                    onClick = {


                        navController.navigate("accountTransaction/${recentAccount.userId}")
                    }

                )
                Spacer(modifier = Modifier.padding(10.dp))

            }
        }

    }

}


@Composable
fun RecentItem(
    modifier: Modifier = Modifier,
    account: Account,
    onClick: ()-> Unit

){
    Card(
        shape = RectangleShape,
        modifier = modifier
            .width(100.dp)
            .height(120.dp)
            .shadow(4.dp, RoundedCornerShape(10.dp))
            .clickable { onClick() },
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageItemWithName(
                modifier = Modifier
                    .padding(2.dp)
                    .height(50.dp)
                    .width(50.dp)
                ,
                name = account.name
            )

            Text(
                text = if(account.isActive) "active" else "inactive",
                style = MaterialTheme.typography.bodySmall,
                color = Color.LightGray
            )
        }
    }
    //   Spacer(modifier = Modifier.padding(0.dp))
}
