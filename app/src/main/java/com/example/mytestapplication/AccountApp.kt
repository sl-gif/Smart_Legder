package com.example.mytestapplication

import android.app.Application
import dagger.Component
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@HiltAndroidApp
class AccountApp : Application(){

}