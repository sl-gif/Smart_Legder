package com.example.mytestapplication.di

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mytestapplication.presentation.viewmodel.SharedViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
/*
@Module
@InstallIn(ActivityComponent::class)
object AppModuleSecond {

    @Provides
    @ActivityScoped
    fun provideSharedViewModel( activity: ComponentActivity): SharedViewModel {
        return ViewModelProvider(activity)[SharedViewModel::class.java]
    }
}*/