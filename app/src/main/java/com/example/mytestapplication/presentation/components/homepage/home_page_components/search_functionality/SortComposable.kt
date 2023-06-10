package com.example.mytestapplication.presentation.components.homepage.home_page_components.search_functionality

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


/**
 * the click functionality of filter is  not working
 * ANd in com.example.mytestapplication (com.example.mytestapplication/.MainActivity)
PID: 9804
Reason: Input dispatching timed out (9f065a com.example.mytestapplication/com.example.mytestapplication.MainActivity (server) is not responding. Waited 5005ms for FocusEvent(hasFocus=true))
Parent: com.example.mytestapplication/.MainActivity
 * also
 *
 */

@Composable
fun SortIcon(
    modifier: Modifier = Modifier,
    dropDownExpandState: Boolean,
    onDismissRequest: ()-> Unit,
    onSort: (SortState)-> Unit,
    onClick: () -> Unit,
){
    Box{
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */
            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */

            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */
            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */
            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */
            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */
            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */
            
            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */
            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */
            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */
            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */
            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */

            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */

            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */

            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */

            /** apparently if you call the onClick lambda of IconButton
             * and also put a clickable modifier on its child - Icon(),
             * the Icon() modifier takes precedence meaning that in the case
             * you just attach an empty non functional clickable modifier and
             * you put functionality in your IconButton onclick parameter, nothing
             * gets called since the one that takes precedence is empty
             */
            IconButton(
                onClick = {
                    onClick()

                }
            ) {
                Icon(
                    imageVector = Icons.Default.Sort,
                    contentDescription = null,
                    tint = Color.Black,
                )
            }
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */
            /**
             * so commenting out dropdown stops the issue of the iconbutton
             * not clicking, but now how do i add dropdown while it works
             */



            DropdownMenu(
                expanded = dropDownExpandState,
                onDismissRequest = onDismissRequest,

                ) {
                DropdownMenuItem(
                    text = {
                        Text(text ="ascending",
                            color = Color.Black
                        ) },
                    onClick = {
                        onSort( SortState.Ascending)
                        onDismissRequest()
                        //dropDownState != dropDownState
                    },

                    )
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "descending",
                            color = Color.Black
                        )
                    },
                    onClick = {
                        onSort( SortState.Descending)
                        onDismissRequest()
                        //dropDownState != dropDownState
                    },
                )
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "date",
                            color = Color.Black)
                    },
                    onClick = {
                        //dropDownState != dropDownState
                        onSort( SortState.Date)
                        onDismissRequest()

                    },
                )
                DropdownMenuItem(
                    text = {
                        Text(text= "active",
                            color = Color.Black
                        ) },
                    onClick = {
                        //dropDownState != dropDownState
                        onSort(SortState.ActiveState)
                        onDismissRequest()

                    },
                )


            }
        }
    }

}

