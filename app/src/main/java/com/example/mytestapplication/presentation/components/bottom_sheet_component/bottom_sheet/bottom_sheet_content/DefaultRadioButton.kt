package com.example.mytestapplication.presentation.components.bottom_sheet_component.bottom_sheet.bottom_sheet_content

import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mytestapplication.presentation.components.bottom_sheet_component.components.BottomSheetContentType
import com.example.mytestapplication.presentation.components.bottom_sheet_component.components.TransactionType


@Composable
fun DefaultRadioButton(
    onClick: (BottomSheetContentType) -> Unit,
    BottomSheetContentState: BottomSheetContentType
) {


    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        Column {
            RadioButton(
                selected = BottomSheetContentState ==  BottomSheetContentType.Sales(TransactionType.Cash),
                onClick = {
                    onClick(BottomSheetContentType.Sales(TransactionType.Cash))


                },
                colors = RadioButtonDefaults.colors(selectedColor = Color.Blue)

            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "cash sale")

        }
        Column {
            RadioButton(
                selected = BottomSheetContentState == BottomSheetContentType.Purchases(
                    TransactionType.Cash),
                onClick = {
                    onClick(BottomSheetContentType.Purchases(TransactionType.Cash))

                },
                colors = RadioButtonDefaults.colors(selectedColor = Color.Blue)

            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "cash purchase")


        }

        Column {
            RadioButton(
                selected = BottomSheetContentState == BottomSheetContentType.Sales(TransactionType.Credit),
                onClick = {
                    onClick(BottomSheetContentType.Sales(TransactionType.Credit))

                },
                colors = RadioButtonDefaults.colors(selectedColor = Color.Blue)

            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "credit sale")


        }
        Column {
            RadioButton(
                selected = BottomSheetContentState == BottomSheetContentType.Purchases(
                    TransactionType.Credit),
                onClick = {
                    onClick(BottomSheetContentType.Purchases(TransactionType.Credit))

                },
                colors = RadioButtonDefaults.colors(selectedColor = Color.Blue)

            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "credit purchase")


        }
    }
}


