package com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content.credit_purchase_content

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
import com.example.mytestapplication.presentation.components.bottom_sheet_component.components.CreditPurchase
import com.example.mytestapplication.presentation.components.bottom_sheet_component.components.InsertType

@Composable
fun CreditPurchaseBottomSheetContent(
    creditPurchaseState: BtsCreditPurchaseState,
    onInsertTransaction: (InsertType) -> Unit,
    onBtsCreditPurchaseAmountChange: (id: CreditPurchase) -> Unit,
    onBtsCreditPurchaseFocusStateChange: (FocusState) -> Unit,
    onReturnCreditPurchaseStateToDefault: ()->Unit,
    id: Int?
) {

    Column(verticalArrangement = Arrangement.SpaceBetween) {

        Text("date of credit purchase")
        OutlinedTextField(value = "${creditPurchaseState.compressedDate()}", onValueChange = {
        })


         Column(verticalArrangement = Arrangement.SpaceBetween) {
         Text("name of lender")
         OutlinedTextField(value =creditPurchaseState.lenderName, onValueChange = {

             onBtsCreditPurchaseAmountChange(CreditPurchase.LenderName(it))
         }
         )
     }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("amount")
            OutlinedTextField(value = "${creditPurchaseState.amount}", onValueChange = {
                onBtsCreditPurchaseAmountChange(CreditPurchase.Amount(it))

            },
                modifier = Modifier.onFocusChanged {
                    if(creditPurchaseState.amount.isBlank() && !it.hasFocus){
                    }

                }
            )
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("quantity")
            OutlinedTextField(value = "${creditPurchaseState.quantity}", onValueChange = {
                onBtsCreditPurchaseAmountChange(CreditPurchase.Quantity(it))

            },
                modifier = Modifier.onFocusChanged {
                    if(creditPurchaseState.quantity.isBlank() && !it.hasFocus){
                    }

                }
            )
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("date of repayment")
            OutlinedTextField(value = "", onValueChange = {

            }
            )
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("name of product")
            OutlinedTextField(value = creditPurchaseState.name, onValueChange = {
                onBtsCreditPurchaseAmountChange(CreditPurchase.ProductName(it))

            })
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text("description")
            OutlinedTextField(value = creditPurchaseState.description, onValueChange = {
                onBtsCreditPurchaseAmountChange(CreditPurchase.Description(it))

            }
            )
        }

        Button(onClick = {
            onInsertTransaction(
              InsertType.CreditPurchaseInsert(
                  Transaction(
                      type = "credit purchase",
                      amount = creditPurchaseState.amount,
                      lenderName = creditPurchaseState.lenderName,
                      time = System.currentTimeMillis(),
                      accountOwnerId = id!!,
                      nameOfProduct = creditPurchaseState.name,
                      quantity = creditPurchaseState.quantity
                      
                  ).toFinancialData()
              )
            )

            onReturnCreditPurchaseStateToDefault()


        }) {
            Text("Submit")
        }
    }

}

