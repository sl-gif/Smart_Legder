package com.example.mytestapplication.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

val listOfNames = listOf(
    "victor",
    "william",
    "hens haw",
    "brick",
    "floodwater",
    "nameless",
    "lifeboatmen"
)


class SharedViewModel  : ViewModel() {

   private val _flowData = MutableStateFlow<List<String>>(emptyList())
     val flowData = _flowData.asStateFlow()
    var dataJob: Job? =  null


    init {
        Log.d("addREcenriniii","initialized")
        getFlowData()
    }

    private fun getFlowData(){
        dataJob = viewModelScope.launch {
          timerSender(5000,listOfNames,0).collect{ value ->
               Log.d("collection","collection started")
               _flowData.value = value

           }
       }

        Log.d("Job","this job $dataJob has started")

    }

    suspend fun timerSender(
        time: Long,
        names: List<String> = listOf("john"),
        index: Int
    ) : Flow<List<String>> {

        return flow {
            names.forEach { name->
                emit(listOf(name))
                delay(time)
            }
        }

    }

}