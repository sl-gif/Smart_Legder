package com.example.mytestapplication.presentation.components.homepage.home_page_components.search_functionality

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun SearchBoxAndSortStartState(
    modifier: Modifier = Modifier,
    searchBoxText: String,
    onValueChange: (String) -> Unit,
    dropDownExpandState: Boolean,
    onDismissRequest: () -> Unit,
    onFilter: (SortState)-> Unit,
    onClick: ()-> Unit,
    navigateToSearchFunctionalityScreen: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "All Accounts",
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    SearchBox(
                        modifier = modifier,
                        searchBoxText = searchBoxText,
                        onValueChange = onValueChange,
                        navigateToSearchFunctionalityScreen = navigateToSearchFunctionalityScreen
                    )

                    SortIcon(
                        dropDownExpandState = dropDownExpandState,
                        onDismissRequest = onDismissRequest,
                        onSort = onFilter,
                        onClick = onClick
                    )

                }
            }
        }
    }
}


@Composable
fun SearchBoxAndSortEndState(
    modifier: Modifier = Modifier,
    searchBoxText: String,
    onValueChange: (String) -> Unit,
    navigateToSearchFunctionalityScreen: () -> Unit

) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(0xFFf2fdff))
        ,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "All Accounts",
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SearchBox(
                modifier = modifier,
                searchBoxText = searchBoxText,
                onValueChange = onValueChange,
                navigateToSearchFunctionalityScreen = navigateToSearchFunctionalityScreen
            )

        }
        IconButton(
            onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Sort,
                contentDescription = null,
                tint = Color.Black,
            )
        }
    }
}


sealed class SortState {
    object Ascending: SortState()
    object Descending: SortState()
    object Date: SortState()
    object ActiveState : SortState()
}

