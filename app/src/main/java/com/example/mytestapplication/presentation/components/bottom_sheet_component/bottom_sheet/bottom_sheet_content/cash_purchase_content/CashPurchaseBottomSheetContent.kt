package com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.cash_purchase_content

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
import com.example.mytestapplication.presentation.components.bottom_sheet_component.components.CashPurchase
import com.example.mytestapplication.presentation.components.bottom_sheet_component.components.InsertType


@Composable
fun CashPurchaseBottomSheetContent(
    cashPurchaseState: BtsCashPurchaseState,
    onInsertTransaction: (InsertType) -> Unit,
    onBtsCashPurchaseAmountChange: (id: CashPurchase) -> Unit,
    onBtsCashPurchaseFocusStateChange: (FocusState) -> Unit,
    onReturnCashPurchaseStateToDefault: ()->Unit,
    id: Int?
) {
    Column(verticalArrangement = Arrangement.SpaceBetween) {

        Text("date of cash purchase")
        OutlinedTextField(value = "${cashPurchaseState.compressedDate()}", onValueChange = {
        })

        /* Column(verticalArrangement = Arrangement.SpaceBetween) {
          Text("date of transaction")
          OutlinedTextField(value = btsTextBoxState.value.time.toString(), onValueChange = {
              btsTextBoxState.value = btsTextBoxState.value.copy(
                  time = it.toLong()
              )
          })
      }*/

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("amount")
            OutlinedTextField(value = "${cashPurchaseState.amount}", onValueChange = {
                onBtsCashPurchaseAmountChange(CashPurchase.Amount(it))

            },
                modifier = Modifier.onFocusChanged {
                    if(cashPurchaseState.amount.isBlank() && !it.hasFocus){
                    }

                }
            )
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("quantity")
            OutlinedTextField(value = "${cashPurchaseState.quantity}", onValueChange = {
                onBtsCashPurchaseAmountChange(CashPurchase.Quantity(it))

            },
                modifier = Modifier.onFocusChanged {
                    if(cashPurchaseState.quantity.isBlank() && !it.hasFocus){
                        //   cashSaleState.value = cashSaleState.value.copy(quantity = "0")
                    }

                }
            )
        }


        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("name of product")
            OutlinedTextField(value = cashPurchaseState.name, onValueChange = {
                onBtsCashPurchaseAmountChange(CashPurchase.ProductName(it))

            })
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("description")
            OutlinedTextField(value = cashPurchaseState.description, onValueChange = {
                onBtsCashPurchaseAmountChange(CashPurchase.Description(it))

            })
        }
        Button(onClick = {
            onInsertTransaction(
                InsertType.CashPurchaseInsert(
                Transaction(
                    type = "cash purchase",
                    amount = cashPurchaseState.amount,
                    accountOwnerId = id!!,
                    quantity = cashPurchaseState.quantity,
                    nameOfProduct = cashPurchaseState.name,
                    time = System.currentTimeMillis()
                ).toFinancialData()
            ))

            onReturnCashPurchaseStateToDefault()


        }) {
            Text("Submit")
        }

    }

}
