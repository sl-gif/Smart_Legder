package com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.cash_sale_content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import com.example.mytestapplication.data.datasource.entity.Transaction
import com.example.mytestapplication.data.datasource.entity.toFinancialData
import com.example.mytestapplication.presentation.components.bottom_sheet_component.components.CashSale
import com.example.mytestapplication.presentation.components.bottom_sheet_component.components.InsertType


@Composable
fun CashSaleBottomSheetContent(
    cashSaleState: BtsCashSaleState,
    onBtsCashSaleAmountChange: ( id: CashSale) -> Unit,

    onBtsCashSaleFocusStateChange: (FocusState) -> Unit,
    onReturnCashSaleStateToDefault: ()->Unit,
    onInsertTransaction: (InsertType)-> Unit,
    id: Int?

) {



    Column {

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("date of sale")
            OutlinedTextField(value = "${cashSaleState.compressedDate()}", onValueChange = {
            })
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("amount")
            OutlinedTextField(value = "${cashSaleState.amount}", onValueChange = {
                //  cashSaleState.value = cashSaleState.copy(amount = it)
                onBtsCashSaleAmountChange(CashSale.Amount(it))

            },
                modifier = Modifier.onFocusChanged {
                    if(cashSaleState.amount.isBlank() && !it.hasFocus){
                        //  cashSaleState.value = cashSaleState.value.copy(amount = "0.00")
                        //      onBtsCashSaleFocusStateChange(it)


                    }

                }
            )
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("quantity")
            OutlinedTextField(value = "${cashSaleState.quantity}", onValueChange = {
                //     cashSaleState.value = cashSaleState.value.copy(quantity = it)
                //   onBtsCashSaleQuantityChange(it)
                onBtsCashSaleAmountChange(CashSale.Quantity(it))



            },
                modifier = Modifier.onFocusChanged {
                    if(cashSaleState.quantity.isBlank() && !it.hasFocus){
                        //        cashSaleState.value = cashSaleState.value.copy(quantity = "0")
                        //      onBtsCashSaleFocusStateChange(it)

                    }

                }
            )
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("name of product")
            OutlinedTextField(value = cashSaleState.name, onValueChange = {
                //       cashSaleState.value = cashSaleState.value.copy(name = it)
                //      onBtsCashSaleNameChange(it)
                onBtsCashSaleAmountChange(CashSale.ProductName(it))



            })
        }
    }

    Column(verticalArrangement = Arrangement.SpaceBetween) {
        Text("description")
        OutlinedTextField(value = cashSaleState.description, onValueChange = {
            //     cashSaleState.value = cashSaleState.value.copy(description = it)
            //     onBtsCashSaleDescriptionChange(it)
            onBtsCashSaleAmountChange(CashSale.Description(it))



        })
    }

    Button(onClick = {
        /**
         * consider using launched effect to prevent repeated insertion
         * repeated insertion occurs when there is recomposition-which
         * is unpredictable. to my knowledge it doesn't seem to be an issue here
         * but in the case where a cashSaleState change triggers lambda call, then
         * if the cashSaleState is changed lambda gets called causing a recomposition,
         * which re-reads the cashSaleState and sees that cashSaleState still meets condition
         * for call, then it calls and the same thing keep happening in a loop
         *
         */

        /**
         * consider using launched effect to prevent repeated insertion
         * repeated insertion occurs when there is recomposition-which
         * is unpredictable. to my knowledge it doesn't seem to be an issue here
         * but in the case where a cashSaleState change triggers lambda call, then
         * if the cashSaleState is changed lambda gets called causing a recomposition,
         * which re-reads the cashSaleState and sees that cashSaleState still meets condition
         * for call, then it calls and the same thing keep happening in a loop
         *
         */

        onInsertTransaction(
            InsertType.CashSaleInsert(
            Transaction(
                type = "cash sale",
                amount = cashSaleState.amount,
                accountOwnerId = id!!,
                quantity = cashSaleState.quantity,
                nameOfProduct = cashSaleState.name,
                time = System.currentTimeMillis()
            ).toFinancialData()
        ))
        onReturnCashSaleStateToDefault
    }) {
        Text("Submit")
    }
}

