package com.example.mytestapplication.presentation.components.bottom_sheet_component.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.mytestapplication.data.datasource.entity.AccountWithTransaction
import com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.util.components.AccountDetailPage
import com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.BottomSheetContent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AccountDetailPageBottomSheet(
    onInsertTransaction: (InsertType) -> Unit,
    id: Int?,
    transactions: List<AccountWithTransaction>,
    name: String

) {
    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetContentTypeState: MutableState<BottomSheetContentType> = remember {
        mutableStateOf(BottomSheetContentType.Sales(TransactionType.Cash))


    }


    BackHandler(bottomSheetState.isVisible) {

        coroutineScope.launch {
            bottomSheetState.hide()
        }
    }
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            BottomSheetContent(

                id = id,
                
                bottomSheetContentTypeState = bottomSheetContentTypeState.value,
                bottomSheetContentTypeRadioButtonClicked = { 
                    bottomSheetContentTypeState.value = it
                },
                onInsertTransaction = onInsertTransaction,
                
                

                )
        },
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            modifier = Modifier.background(Color(0xFFf2fdff)),
            contentColor = Color(0xFFffffff),
            topBar = {
            },
            snackbarHost = { },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                }) {
                    Text("Click to open bts")
                }
            },

            ) { paddingValues ->
            paddingValues


            Box(modifier = Modifier.background(Color(0xFFf2fdff))) {
                AccountDetailPage(
                    transactions = transactions,
                    name = "${name + id }",


                )

            }
        }
    }
}

