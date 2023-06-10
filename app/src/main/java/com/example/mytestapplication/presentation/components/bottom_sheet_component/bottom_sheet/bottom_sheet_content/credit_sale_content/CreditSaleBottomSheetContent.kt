package com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.credit_sale_content

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
import com.example.mytestapplication.presentation.components.bottom_sheet_component.components.CreditSale
import com.example.mytestapplication.presentation.components.bottom_sheet_component.components.InsertType


@Composable
fun CreditSaleBottomSheetContent(
    creditSaleState: BtsCreditSaleState,
    onInsertTransaction: (InsertType) -> Unit,
    onBtsCreditSaleAmountChange: (id: CreditSale) -> Unit,
    onBtsCreditSaleFocusStateChange: (FocusState) -> Unit,
    onReturnCreditSaleStateToDefault: ()->Unit,
    id: Int?

) {


    Column() {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("date of credit sale")
            OutlinedTextField(value = "${creditSaleState.compressedDate()}", onValueChange = {


            })
        }
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("name of debtor")
            OutlinedTextField(value = creditSaleState.borrowerName, onValueChange = {

                onBtsCreditSaleAmountChange(CreditSale.DebtorName(it))
            })
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("amount")
            OutlinedTextField(value = "${creditSaleState.amount}", onValueChange = {

                onBtsCreditSaleAmountChange(CreditSale.Amount(it))

            },
                modifier = Modifier.onFocusChanged {
                    if(creditSaleState.amount.isBlank() && !it.hasFocus){
                        onBtsCreditSaleFocusStateChange
                    }

                }
            )
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("quantity")
            OutlinedTextField(value = "${creditSaleState.quantity}", onValueChange = {

                onBtsCreditSaleAmountChange(CreditSale.Quantity(it))

            },
                modifier = Modifier.onFocusChanged {
                    if(creditSaleState.quantity.isBlank() && !it.hasFocus){
                        onBtsCreditSaleFocusStateChange
                    }

                }
            )
        }


        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("date of collection")
            OutlinedTextField(value = "${creditSaleState.compressedDate()}", onValueChange = {

            })
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("name of product")
            OutlinedTextField(value = creditSaleState.name, onValueChange = {
                onBtsCreditSaleAmountChange(CreditSale.ProductName(it))

            })
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("description")
            OutlinedTextField(value = creditSaleState.description, onValueChange = {
                onBtsCreditSaleAmountChange(CreditSale.Description(it))

            })
        }

        Button(onClick = {
            onInsertTransaction(
                InsertType.CashSaleInsert(
                Transaction(
                    type = "credit sale",
                    amount = creditSaleState.amount,
                    accountOwnerId = id!!,
                    quantity = creditSaleState.quantity,
                    nameOfProduct = creditSaleState.name,
                    time = System.currentTimeMillis()
                ).toFinancialData()
            ))

            onReturnCreditSaleStateToDefault()

        }) {
            Text("Submit")
        }
    }

}
