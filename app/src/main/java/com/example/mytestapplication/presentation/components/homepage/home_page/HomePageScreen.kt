package com.example.mytestapplication.presentation.components.homepage.home_page

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mytestapplication.R
import com.example.mytestapplication.data.datasource.entity.Account
import com.example.mytestapplication.presentation.components.homepage.home_page_components.account_component.AccountItem
import com.example.mytestapplication.presentation.components.homepage.home_page_components.account_component.AccountState
import com.example.mytestapplication.presentation.components.homepage.home_page_components.recent_account_component.RecentItemComponent
import com.example.mytestapplication.presentation.components.homepage.home_page_components.primary_account_package.PrimaryAccountComponent
import com.example.mytestapplication.presentation.components.homepage.home_page_components.search_functionality.*
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

data class User(
    val image: Int,
    val name: String,
    val isActive: Boolean

)

val accounts = listOf(
    User(
        image = R.drawable.images,
        name = "william frost",
        isActive = true

    ),
    User(
        image = R.drawable.imagestwo,
        name = "laura cindy",
        isActive = false
    ),
    User(
        image = R.drawable.imagesthree,
        name = "steve page",
        isActive = true

    ),
    User(
        image = R.drawable.imagesfour,
        name = "kevin samuel",
        isActive = false

    ),
    User(
        image = R.drawable.imagesfive,
        name = "garry potter",
        isActive = false

    ),
    User(
        image = R.drawable.imagessix,
        name = "chuck olsen",
        isActive = false

    ),
    User(
        image = R.drawable.imagesseven,
        name = "angelina tate",
        isActive = false

    ),
    User(
        image = R.drawable.imageseight,
        name = "nelly faustina",
        isActive = true

    ),
    User(
        image = R.drawable.imagesnine,
        name = "matt walsh",
        isActive = true

    ),
)


@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalAnimationApi::class
)
@Composable
fun HomePageScreen(
    modifier: Modifier = Modifier,
    accountState: AccountState,
    navController: NavController,
    onSearchBoxTextChange: (String) -> Unit,
    onFilterItem: (SortState) -> Unit,
    onDeleteAccount: (Account) -> Unit,


    ) {

    val recentAccounts = accountState.recentAccount
    val snackBarState = remember { SnackbarHostState() }
    val account = accountState.account
    val lazyListState = rememberLazyListState()
    var expanded by remember { mutableStateOf(false) }
    val searchBoxText = accountState.searchBoxText
    val scope = rememberCoroutineScope()
    var dropDownExpandState by remember { mutableStateOf(false) }

    var animate = remember {
        mutableStateOf(50.dp)
    }

    Scaffold(
        containerColor = Color(0xFFf2fdff),
        contentColor = Color(0xFFffffff),
        topBar = {
        },
        snackbarHost = { SnackbarHost(hostState = snackBarState) },
        floatingActionButton = {
            FloatingActionButton(
                //       containerColor = Color(MaterialTheme.colorScheme.primary.toArgb()),
                onClick = {
                },

                ) {
                IconButton(
                    // modifier = Modifier
                    //     .background(MaterialTheme.colorScheme.primary),

                    onClick = {
                        /** i thought since this is a one off event, it requires
                        a coroutinescope, i guess you have to read more about
                       coroutine scopes and one off events
                        */
                        scope.launch {
                          //  val data = "yesssssdata"
                            navController.navigate("addAccountScreen")
                        }

                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "add"

                    )
                }

            }
        },

        ) { paddingValues ->
        paddingValues

        LazyColumn(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp),
            state = lazyListState
        ) {

             item {

                 if (recentAccounts == null) {

                     return@item
                 }

                 RecentItemComponent(
                     navController = navController,
                     recentAccounts = recentAccounts
                 )
             }

             item {
                 PrimaryAccountComponent{ navArg ->
                     scope.launch {

                         navController.navigate("primaryAccountScreen/$navArg")

                     }
                 }
             }

            stickyHeader {
                AnimatedContent(
                    targetState = expanded,
                    transitionSpec = {
                        fadeIn(animationSpec = tween(0, 0)) with
                                fadeOut(animationSpec = tween(0, 0)) using
                                SizeTransform { initialSize, targetSize ->
                                    if (targetState) {
                                        keyframes {
                                            //vertical first
                                            IntSize(targetSize.width, initialSize.height) at 1500
                                            //horizontal first
                                            IntSize(initialSize.width, targetSize.height) at 150

                                            durationMillis = 30
                                        }
                                    } else {
                                        keyframes {
                                            IntSize(initialSize.width, targetSize.height) at 150
                                            durationMillis = 300
                                        }

                                    }
                                }

                    }
                ) { targetExpanded ->

                    if (targetExpanded) {

                        SearchBoxAndSortEndState(
                            modifier = Modifier.fillMaxWidth(),
                            searchBoxText = searchBoxText,
                            onValueChange = { onSearchBoxTextChange(it) },
                            navigateToSearchFunctionalityScreen = {
                                navController.navigate("searchFunctionalityScreen")
                            }
                        )

                    } else {


                        SearchBoxAndSortStartState(
                            searchBoxText = searchBoxText,
                            onValueChange = { onSearchBoxTextChange(it) },
                            dropDownExpandState = dropDownExpandState,
                            onDismissRequest = {
                                dropDownExpandState = !dropDownExpandState
                            },
                            onFilter = { onFilterItem

                            },
                            onClick = {
                                Log.d("DropDownDebug", "$dropDownExpandState is value")
                                dropDownExpandState = !dropDownExpandState
                            },
                            navigateToSearchFunctionalityScreen = {
                                navController.navigate("searchFunctionalityScreen")

                            }
                        )

                    }

                }

            }

            if (account.isNotEmpty()) {
                items(account.size) { index ->

                    /**
                     * this accountItem composable has a navigation
                     * event, but it doesn't seem to have issues when
                     * i navigate even though i don't call it in a controlled
                     * environment like LaunchedEffect but calling navigation
                     * in searchBox composable outside LaunchedEffect is problematic
                     */


                    AccountItem(
                        modifier = Modifier.height(80.dp),
                        account = account[index],
                        onClick = {
                            Log.d("crashh","${account[index].date.hashCode()}")

                            val userId = account[index].userId
                            val name = account[index].name


                            navController.navigate("accountTransaction/$userId/$name")

                        },

                        onDeleteClick = {onDeleteAccount(account[index])}
                        )

                }
            } else {
                item {
                    Column(

                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                   //     modifier = Modifier.weight(1f)   .weight(1f).background(Color.Green)
                    ) {
                        Box(modifier = Modifier//.weight(1f)
                            .background(Color.Green)) {
                            Text(
                                text = "No Accounts Yet",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                            )

                        }
                    }

                }
            }
            }
        }

        LaunchedEffect(Unit) {

            snapshotFlow { lazyListState.layoutInfo.visibleItemsInfo }
                .filter {
                    it.isNotEmpty()
                }
                .collect { visibleitems ->
                    val firstVisibleItemIndex = visibleitems[0].index

                    if (firstVisibleItemIndex == 2) {

                        animate.value = 100.dp
                        expanded = true

                    }

                }

        }
    }


