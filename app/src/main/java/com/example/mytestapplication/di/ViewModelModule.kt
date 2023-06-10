package com.example.mytestapplication.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
/*
@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideViewModelProvider(viewModelStoreOwner: ViewModelStoreOwner, app: Application): ViewModelProvider{
        return ViewModelProvider(viewModelStoreOwner,ViewModelProvider.AndroidViewModelFactory.getInstance(
           app
        ))
    }
}*/