package com.example.mytestapplication.presentation.components.homepage.home_page_components.search_functionality

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mytestapplication.presentation.viewmodel.AccountViewModel

@Composable
fun SearchBox(
    modifier: Modifier = Modifier,
    searchBoxText: String,
    viewModel: AccountViewModel = hiltViewModel(),
    onValueChange: (String) -> Unit,
    navigateToSearchFunctionalityScreen: () -> Unit
) {


    Box{
        BasicTextField(
            textStyle = TextStyle(color = Color.Black),
            value = searchBoxText,
            enabled = true,
            onValueChange = onValueChange,
            modifier = modifier
                .width(200.dp)
                .height(50.dp)
                .padding(bottom = 4.dp)
                .border(1.dp,Color.Black, RoundedCornerShape(2.dp))
                .onFocusChanged {
                    viewModel.changeFocusState(it)
                },
            singleLine = true
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.searchBoxState.value.isHintVisible) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }

                Text(viewModel.searchBoxState.value.hint, color = Color.LightGray)
            }else{
                LaunchedEffect(key1 = Unit){
                    navigateToSearchFunctionalityScreen()
                }
            }
        }
    }

}


