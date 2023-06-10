package com.example.mytestapplication.presentation.components.add_account_page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mytestapplication.data.datasource.entity.Account
import com.example.mytestapplication.data.datasource.entity.toFinancialData
import com.example.mytestapplication.presentation.components.bottom_sheet_component.components.InsertType
import java.time.OffsetDateTime
import kotlin.random.Random

@Composable
fun AddAccount(
    insertAccount: (InsertType)-> Unit,
    navController: NavController
){
    val addContactsTextBoxState = remember{
        mutableStateOf(
            AddAccountTextState(
                 name  = "",
             isActive = true ,
         date = OffsetDateTime.now(),
        isSubmitted = false
            )
        )
    }



        Column(
               modifier = Modifier.fillMaxSize()
           ) {

                OutlinedTextField(value = addContactsTextBoxState.value.name,
                    onValueChange = {
                    addContactsTextBoxState.value = addContactsTextBoxState.value.copy(
                        name = it
                    )
                },
                    label = { Text("name")}
                )


                OutlinedTextField(value = addContactsTextBoxState.value.customisedDate(),
                    onValueChange = {
                },
                    label = { Text("date")}


                )


            Button(onClick = {

                insertAccount(
                    InsertType.Account(
                    Account(
                        name = addContactsTextBoxState.value.name,
                        isActive = Random.nextBoolean(),
                        //   dateOfItemRecentClick = OffsetDateTime.now()
                        date = OffsetDateTime.now()
                    ).toFinancialData()
                ))

                addContactsTextBoxState.value = addContactsTextBoxState.value.copy(
                    name = "",
                    isSubmitted = true

                )
                navController.popBackStack()

            }) {
                Text("Submit")
            }
        }

}



