package com.example.mytestapplication.presentation.components.homepage.home_page_components.search_functionality

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mytestapplication.data.datasource.entity.Account
import com.example.mytestapplication.domain.model.SearchBoxState
import com.example.mytestapplication.presentation.viewmodel.AccountViewModel

//it would seem that calling a callback in a animation component would
//result in constant redrawing of animation
//maybe launching a new page from animation is a bad idea
//when i compose an item in lazy column ,it seems to recompose frequently
//when i navigate from my custom search state function, it recomposes many times
//unlike when i navigate from card

@Composable
fun SearchFunctionalityScreen(
    searchBoxText: String,
    searchedText: List<Account> ,
    onValueChange: (String)-> Unit

) {


    LazyColumn {
        item {
            SearchBox(
                modifier = Modifier.fillMaxWidth(),
                searchBoxText = searchBoxText,
                onValueChange = {onValueChange(it)},
                navigateToSearchFunctionalityScreen = {}
            )

        }

        items(searchedText) { searchedAccount ->

                Text(
                    text ="${searchedAccount.name}",
                    color = Color.Black
                )
            Spacer(modifier = Modifier.height(8.dp))



        }

    }
}