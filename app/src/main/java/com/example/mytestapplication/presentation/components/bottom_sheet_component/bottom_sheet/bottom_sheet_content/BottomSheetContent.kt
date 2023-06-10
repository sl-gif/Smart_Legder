package com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.cash_purchase_content.BtsCashPurchaseState
import com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.cash_purchase_content.CashPurchaseBottomSheetContent
import com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.cash_sale_content.BtsCashSaleState
import com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.cash_sale_content.CashSaleBottomSheetContent
import com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.credit_purchase_content.BtsCreditPurchaseState
import com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.credit_purchase_content.CreditPurchaseBottomSheetContent
import com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.credit_sale_content.BtsCreditSaleState
import com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.credit_sale_content.CreditSaleBottomSheetContent
import com.example.mytestapplication.presentation.components.bottom_sheet_component.components.*
import java.time.OffsetDateTime


@Composable
fun BottomSheetContent(
    id: Int?,
    onInsertTransaction: (InsertType) -> Unit,
    bottomSheetContentTypeState: BottomSheetContentType = BottomSheetContentType.Sales(
        TransactionType.Cash),
    bottomSheetContentTypeRadioButtonClicked: (BottomSheetContentType) -> Unit
) {


    var creditSaleState by remember {
        mutableStateOf(
            BtsCreditSaleState(
                date = OffsetDateTime.now(),
                amount = "0.00",
                description = "",
                quantity = "0",
                name = "",

                )
        )
    }

    var cashSaleState by remember {
        mutableStateOf(
            BtsCashSaleState(
                date = OffsetDateTime.now(),
                amount = "0.00",
                description = "",
                quantity = "0",
                name = "",

                )
        )
    }


    var cashPurchaseState by remember {
        mutableStateOf(
            BtsCashPurchaseState(
                date = OffsetDateTime.now(),
                amount = "0.00",
                description = "",
                quantity = "0",
                name = "",

                )
        )
    }
    var creditPurchaseState by remember {
        mutableStateOf(
            BtsCreditPurchaseState(
                date = OffsetDateTime.now(),
                amount = "0.00",
                description = "",
                quantity = "0",
                name = "",

                )
        )
    }



    Column (modifier = Modifier.padding(8.dp)){

        DefaultRadioButton(
            onClick = bottomSheetContentTypeRadioButtonClicked,
            BottomSheetContentState = bottomSheetContentTypeState
        )

        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        when (bottomSheetContentTypeState.transactionType) {
            is TransactionType.Cash -> {
                when (bottomSheetContentTypeState) {
                    is BottomSheetContentType.Sales -> {
                        CashSaleBottomSheetContent(
                            onInsertTransaction = onInsertTransaction,
                            cashSaleState = cashSaleState,

                            onBtsCashSaleFocusStateChange = {

                            },
                            onBtsCashSaleAmountChange = {  arg ->
                                when(arg){
                                    is CashSale.Amount -> {
                                        cashSaleState = cashSaleState.copy(amount = arg.id)

                                    }
                                    is CashSale.Quantity -> {
                                        cashSaleState = cashSaleState.copy(quantity = arg.id)

                                    }
                                    is CashSale.ProductName -> {
                                        cashSaleState = cashSaleState.copy(name = arg.id)

                                    }
                                    is CashSale.Description -> {
                                        cashSaleState = cashSaleState.copy(description = arg.id)

                                    }
                                }

                            },

                            onReturnCashSaleStateToDefault =  {

                                cashSaleState = cashSaleState.returnToDefault()


                            },
                            id = id

                        )
                    }
                    is BottomSheetContentType.Purchases -> {
                        CashPurchaseBottomSheetContent(
                            onInsertTransaction = onInsertTransaction,
                            cashPurchaseState = cashPurchaseState,
                            onBtsCashPurchaseFocusStateChange = {},
                            onBtsCashPurchaseAmountChange = {  arg ->
                                when(arg){
                                    is CashPurchase.Amount -> {
                                        cashPurchaseState = cashPurchaseState.copy(amount = arg.id)

                                    }
                                    is CashPurchase.Quantity -> {
                                        cashPurchaseState = cashPurchaseState.copy(quantity = arg.id)

                                    }
                                    is CashPurchase.ProductName -> {
                                        cashPurchaseState = cashPurchaseState.copy(name = arg.id)

                                    }
                                    is CashPurchase.Description -> {
                                        cashPurchaseState = cashPurchaseState.copy(description = arg.id)

                                    }
                                }

                            },
                            onReturnCashPurchaseStateToDefault = {
                                cashPurchaseState = cashPurchaseState.returnToDefault()
                            },
                            id = id)

                    }
                }
            }
            is TransactionType.Credit -> {
                when (bottomSheetContentTypeState) {
                    is BottomSheetContentType.Sales -> {
                        CreditSaleBottomSheetContent(
                            onInsertTransaction = onInsertTransaction,
                            creditSaleState = creditSaleState,
                            onBtsCreditSaleFocusStateChange = {},
                            onBtsCreditSaleAmountChange = {  arg ->
                                when(arg){
                                    is CreditSale.Amount -> {
                                        creditSaleState = creditSaleState.copy(amount = arg.id)

                                    }
                                    is CreditSale.Quantity -> {
                                        creditSaleState = creditSaleState.copy(quantity = arg.id)

                                    }
                                    is CreditSale.ProductName -> {
                                        creditSaleState = creditSaleState.copy(name = arg.id)

                                    }
                                    is CreditSale.Description -> {
                                        creditSaleState = creditSaleState.copy(description = arg.id)

                                    }
                                }

                            },
                            onReturnCreditSaleStateToDefault = {
                                creditSaleState = creditSaleState.returnToDefault()
                            },
                            id = id

                        )
                    }

                    is BottomSheetContentType.Purchases -> {
                        CreditPurchaseBottomSheetContent(
                            onInsertTransaction = onInsertTransaction,
                            onReturnCreditPurchaseStateToDefault = {
                                creditPurchaseState = creditPurchaseState.returnToDefault()
                            },
                            onBtsCreditPurchaseFocusStateChange = {},


                            creditPurchaseState = creditPurchaseState,
                            onBtsCreditPurchaseAmountChange = {  arg ->
                                when(arg){
                                    is CreditPurchase.Amount -> {
                                        creditPurchaseState = creditPurchaseState.copy(amount = arg.id)

                                    }
                                    is CreditPurchase.Quantity -> {
                                        creditPurchaseState = creditPurchaseState.copy(quantity = arg.id)

                                    }
                                    is CreditPurchase.ProductName -> {
                                        creditPurchaseState = creditPurchaseState.copy(name = arg.id)

                                    }
                                    is CreditPurchase.Description -> {
                                        creditPurchaseState = creditPurchaseState.copy(description = arg.id)

                                    }
                                }

                            },
                            id = id

                        )

                    }
                }
            }


        }
    }
}

