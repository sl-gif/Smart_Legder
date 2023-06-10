package com.example.mytestapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mytestapplication.data.datasource.entity.toAccount
import com.example.mytestapplication.data.datasource.entity.toTransaction
import com.example.mytestapplication.presentation.components.add_account_page.AddAccount
import com.example.mytestapplication.presentation.components.bottom_sheet_component.components.AccountDetailPageBottomSheet
import com.example.mytestapplication.presentation.components.bottom_sheet_component.components.InsertType
import com.example.mytestapplication.presentation.components.homepage.home_page.HomePageScreen
import com.example.mytestapplication.presentation.components.homepage.home_page_components.account_component.AccountState
import com.example.mytestapplication.presentation.components.homepage.home_page_components.primary_account_package.PrimaryAccountType
import com.example.mytestapplication.presentation.components.homepage.home_page_components.search_functionality.SearchFunctionalityScreen
import com.example.mytestapplication.presentation.components.primary_account_details.PrimaryAccountDetails
import com.example.mytestapplication.presentation.viewmodel.AccountDetailViewModel
import com.example.mytestapplication.presentation.viewmodel.AccountViewModel
import com.example.mytestapplication.presentation.viewmodel.PrimaryAccountViewModel
import com.example.mytestapplication.presentation.viewmodel.listOfNames
import com.example.mytestapplication.ui.theme.MyTestApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor() : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MyTestApplicationTheme {
                // A surface container using the 'background' color from the theme

                //i was just testing coroutines
                //but the issue of lambda call only in the scope of a launched effect
                //solving the issue needs to be understood
                /*    var data by remember{ mutableStateOf(0) }
                var data2 by remember{ mutableStateOf(0) }
                var data3 by remember{ mutableStateOf(0) }
                var data4 by remember{ mutableStateOf(0) }

                /* LaunchedEffect(key1 = Unit) {
                     lifecycleScope.launch {
                         networkCall()

                         networkCall2()


                     }

                 }*/


                Column {
                    val content = ComposeContent(data,data2,data3,data4)
                    Button(onClick = {
                        lifecycleScope.launch {
                            launch {
                                networkCall(data, { data++ })
                            }
                            delay(500)
                            networkCall(data2,{data2++})


                        }

                       /* lifecycleScope.launch {
                            networkCall(data3,{data3++})

                            networkCall(data4,{data4++})

                        }*/
                    }) {
                        Text("click")
                    }

                    if (content) {
                        Log.d("content", "content composed")
                    }

                }*/


                Surface {


                /*    var cashSaleState by remember {
                        mutableStateOf("")
                    }

                    TextBox(cashSaleState = cashSaleState) {
                        cashSaleState = it
                    }*/


              //      TextBoxWithInternalState()
                    /*  val data = viewModel.flowData.collectAsState()
                    val navController = rememberNavController()

                     NavHost(navController = navController, startDestination = "firstScreen") {

                        composable("firstScreen") {

                            FirstScreen(navController = navController, data = data)

                        }

                         composable("secondScreen") {

                             SecondScreen(navController)

                         }



                       }*/
                /*   var count by remember{ mutableStateOf(0) }
                    var data: StateFlow<List<String>>?

                    val cashSaleState = remember(key1 = count){
                       data = getFlowData()
                       mutableStateOf(data)
                   }.value?.collectAsState()

                    LazyColumn {

                            if (cashSaleState != null) {
                                items(cashSaleState.value) {
                                    Text("$it")

                                    Button(onClick = { count++ }) {

                                    }
                                }
                        }
                    }*/
/*
                    val demo = FinancialDataDemo(
                        name = "name",
                        dateOfItemRecentClick = OffsetDateTime.now(),
                        date = OffsetDateTime.now(),
                        userId = 0,
                        isActive = true,
                        type = "type",
                        amount = "666",
                        lenderName = "me",
                        borrowerName = "you",
                        time = System.currentTimeMillis(),
                        transactionId = "90",
                        accountOwnerId = 8,
                        quantity = "600",
                        nameOfProduct = "product"
                    )

                    Text(text="${demo.makeNull(dateOfItemRecentClick = true, userId = true)}") */





                    val navController = rememberNavController()
                    val accountViewModel = hiltViewModel<AccountViewModel>()
                    NavHost(navController = navController, startDestination = "homePageScreen") {


                        composable("homePageScreen") {
                            Log.d("transactionnnn Main activity",
                              //  "${accountDetailViewModel.transaction}mmm"
                            "mmm"
                            )


                            HomePageScreen(
                                navController = navController,
                                accountState = AccountState(
                                    account = accountViewModel.accounts.collectAsState().value,
                                    recentAccount = accountViewModel.recentItems.collectAsState(
                                        initial = emptyList()
                                    ).value,
                                    searchBoxText = accountViewModel.searchBoxText.collectAsState().value
                                ),
                                onSearchBoxTextChange = {accountViewModel.searchBoxTextChange(it)},
                                onFilterItem = {accountViewModel.filterItem(it)},
                                onDeleteAccount = {accountViewModel.deleteAccount(it)}
                            )

                        }
                        composable(
                            route = "accountTransaction/{userId}/{name}",
                            arguments = listOf(navArgument("userId") {
                                type = NavType.IntType
                            },navArgument("name") {
                                type = NavType.StringType
                            }
                            )
                        ) {
                            val accountDetailViewModel = hiltViewModel<AccountDetailViewModel>()
                            val userId = it.arguments?.getInt("userId")
                            val name = it.arguments?.getString("name")
                            Log.d("Arguuuu","$userId")



                            if (userId != null) {
                                AccountDetailPageBottomSheet(
                                    id = userId,
                                    transactions = accountDetailViewModel.transaction.value,
                                    name = name!! ,


                                    onInsertTransaction = { inserttype ->

                                        when(inserttype){
                                            is InsertType.CashSaleInsert ->{
                                                accountDetailViewModel.insertTransaction(
                                                    inserttype.financialData.toTransaction()
                                                    /*   Transaction(
                                                                            type = "cash sale",
                                                                            amount = cashSaleState.amount,
                                                                            accountOwnerId = accountDetailViewModel.id!!,
                                                                            quantity = cashSaleState.quantity,
                                                                            nameOfProduct = cashSaleState.name,
                                                                            time = System.currentTimeMillis()
                                                                        )
                                                                        )*/
                                                )
                                            }
                                            is InsertType.CreditSaleInsert ->{
                                                accountDetailViewModel.insertTransaction(
                                                    inserttype.financialData.toTransaction()

                                                    /*     Transaction(
                                                                            type = "credit sale",
                                                                            amount = creditSaleState.amount,
                                                                            accountOwnerId = accountDetailViewModel.id!!,
                                                                            quantity = creditSaleState.quantity,
                                                                            nameOfProduct = creditSaleState.name,
                                                                            time = System.currentTimeMillis()
                                                                        )*/
                                                )

                                            }
                                            is InsertType.CashPurchaseInsert ->{
                                                accountDetailViewModel.insertTransaction(
                                                    inserttype.financialData.toTransaction()
                                                    /*    Transaction(
                                                                            type = "cash purchase",
                                                                            amount = cashPurchaseState.amount,
                                                                            accountOwnerId = accountDetailViewModel.id!!,
                                                                            quantity = cashPurchaseState.quantity,
                                                                            nameOfProduct = cashPurchaseState.name,
                                                                            time = System.currentTimeMillis()
                                                                        )*/
                                                )

                                            }
                                            is InsertType.CreditPurchaseInsert ->{
                                                accountDetailViewModel.insertTransaction(
                                                    inserttype.financialData.toTransaction()
                                                    /*   Transaction(
                                                                            type = "credit purchase",
                                                                            amount = creditPurchaseState.amount,
                                                                            accountOwnerId = accountDetailViewModel.id!!,
                                                                            quantity = creditPurchaseState.quantity,
                                                                            nameOfProduct = creditPurchaseState.name,
                                                                            time = System.currentTimeMillis()
                                                                        )*/
                                                )

                                            }
                                        }

                                    },


                                    )
                            }

                        }

                        composable(
                            route = "addAccountScreen"
                            ) {


                            AddAccount(
                                navController = navController,
                                insertAccount = { insertType ->
                                    when(insertType){
                                        is InsertType.Account->{
                                            accountViewModel.insertAccount(
                                                insertType.financialData.toAccount()
                                            )
                                        }
                                    }

                                }
                            )
                        }

                        composable(
                            route = "primaryAccountScreen/{id}",
                            arguments = listOf(navArgument("id") {
                                type = NavType.EnumType(PrimaryAccountType::class.java)
                            })

                        ) {
                            val primaryAccountViewModel = hiltViewModel<PrimaryAccountViewModel>()
                            val state = primaryAccountViewModel.allTransaction.collectAsState().value

                            PrimaryAccountDetails(state)
                        }
                        composable(route = "searchFunctionalityScreen") {
                            val searchBoxText = accountViewModel.searchBoxText.collectAsState().value
                            val searchedText = accountViewModel.searchedText.collectAsState().value
                            SearchFunctionalityScreen(
                                searchBoxText = searchBoxText,
                                searchedText = searchedText,
                                onValueChange = {
                                    accountViewModel.searchBoxTextChange(it)
                                }
                            )
                        }
                    }
                }
                //      var expanded by remember{ mutableStateOf(false) }
                //      var cashSaleStateData by remember{mutableStateOf(0)}

                /*    Column {
                        Surface(
                            modifier = Modifier.height(300.dp)
                                .width(300.dp)
                                .background(Color.Red)

                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize()
                                    .clickable { expanded = !expanded }
                                    .background(Color.Green)
                            ){

                            }
                        }

                        Text("data $cashSaleStateData is for surface")
                        Text("data $expanded is for Box")

                    }*/

                /*     Column(
                      //    color = MaterialTheme.colorScheme.primary,
                     //    modifier = Modifier.clickable { expanded = !expanded}
                      ){
                          AnimatedContent(
                              targetState = expanded,
                              transitionSpec = {
                                  fadeIn(animationSpec = tween(100,200)) with
                                          fadeOut(animationSpec = tween(100,150)) using
                                          SizeTransform { initialSize, targetSize ->
                                              if(targetState){
                                                  keyframes {
                                                      //vertical first
                                                      IntSize(targetSize.width,initialSize.height) at 1500
                                                      //horizontal first
                                                      IntSize(initialSize.width,targetSize.height) at 150

                                                      durationMillis = 3000
                                                  }
                                              }else{
                                                  keyframes {
                                                      IntSize(initialSize.width,targetSize.height) at 150
                                                      durationMillis = 300
                                                  }

                                              }
                                          }

                              }
                              ) { targetExpanded ->
                              if(targetExpanded){
                                  AnimatableBox(
                                      modifier = Modifier
                                          .width(400.dp)
                                      ,
                                      cashSaleStateData = cashSaleStateData)/* {
                                    cashSaleStateData++
                                  }*/

                              }else{
                                  AnimatableBox(
                                      modifier = Modifier
                                          .width(100.dp)
                                          ,
                                      cashSaleStateData = cashSaleStateData)/* {
                                      cashSaleStateData++
                                  }*/
                              }

                          }

                         Button(onClick = {
                             expanded = !expanded


                         }) {
                             Text("Click")
                         }
                      }*/
            }
        }
    }

    
private fun simulateDoubleCoroutineCall(){
    lifecycleScope.launch {
        getFlowData()
        delay(15000)
        getFlowData()
    }

}

    private fun getFlowData(): StateFlow<List<String>> {
        Log.d("getFlowData", "getFlowDats started")

        val _flowData = MutableStateFlow<List<String>>(emptyList())
        val flowData = _flowData.asStateFlow()
        lifecycleScope.launch {

            timerSender(5000, listOfNames, 0).collect { value ->
                Log.d("collection", "collection started")
                _flowData.value = value


            }
        }

        return flowData

    }

    suspend fun timerSender(
        time: Long,
        names: List<String> = listOf("john"),
        index: Int
    ): Flow<List<String>> {

        return flow {
            names.forEach { name ->
                emit(listOf(name))
                delay(time)
            }


        }

    }


    @Composable
    fun FirstScreen(
        //    viewModel: SharedViewModel,
        data: State<List<String>>,
        navController: NavController
    ) {


        //    val data = viewModel.flowData.collectAsState()
        //  val data = getFlowData().collectAsState()
        val scope = rememberCoroutineScope()



        LazyColumn {
            items(data.value) {
                Text(
                    it
                )

            }

            item {
                Button(onClick = {
                    scope.launch {

                        navController.navigate("secondScreen")
                    }
                }) {
                    Text("navigate to second screen")
                }
            }
        }

        DisposableEffect(key1 = Unit) {

            onDispose {
                Log.d("Disposed", "first screen has been disposed")
            }
        }

    }

    @Composable
    fun SecondScreen(navController: NavController) {
        val scope = rememberCoroutineScope()
        Text("Second Screen")
        Button(onClick = {
            scope.launch {
                navController.popBackStack()
            }
        }) {
            Text("navigate to first screen")
        }
    }


    @Composable
    fun TextBox(cashSaleState: String, event: (String) -> Unit) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column() {
                androidx.compose.material.Text("name")
                OutlinedTextField(value = cashSaleState, onValueChange = {
                    event(it)
                })
            }
        }
    }

    @Composable
    fun TextBoxWithInternalState(){

        var cashSaleState by remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column() {
                androidx.compose.material.Text("name")
                OutlinedTextField(value = cashSaleState, onValueChange = {
                    cashSaleState = it
                })
            }
        }
    }







    suspend fun networkCall(
            data: Int,
            increment: (Int) -> Unit
        ): Int {
            delay(5000)
            Log.d("network call", " network has been called")
            increment(data)
            return data

        }

        @Composable
        fun ComposeContent(
            data: Int,
            data2: Int,
            data3: Int,
            data4: Int,
        ): Boolean {
            Column {
                Row {
                    Text(data.toString())
                    Text(data2.toString())
                }


            }
            return true
        }

        @Composable
        fun AnimatableBox(
            modifier: Modifier = Modifier,
            cashSaleStateData: Int,
            viewModel: AccountViewModel = hiltViewModel()
            //   onClick: () -> Unit
        ) {

            OutlinedTextField(
                modifier = modifier,
                value = viewModel.searchBoxText.collectAsState().value,
                onValueChange = { viewModel.searchBoxTextChange(it) })
        }


        @Composable
        fun Greeting(name: String) {
            Text(text = "Hello $name!")
        }

        @Preview(showBackground = true)
        @Composable
        fun DefaultPreview() {
            MyTestApplicationTheme {
                Greeting("Android")
            }
        }
    }