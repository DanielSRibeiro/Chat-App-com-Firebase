package com.example.realtimechat.data.datasource.di

import com.example.realtimechat.data.datasource.authentication.FirebaseAuthenticationDataSource
import com.example.realtimechat.data.datasource.authentication.FirebaseAuthenticationDataSourceImpl
import com.example.realtimechat.data.datasource.firestore.FirebaseFireStoreDataSource
import com.example.realtimechat.data.datasource.firestore.FirebaseFireStoreDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindFirebaseAuthenticationDataSource(
        firebaseAuthenticationDataSourceImpl: FirebaseAuthenticationDataSourceImpl
    ): FirebaseAuthenticationDataSource

    @Binds
    fun bindFireStoreDataSource(
        firebaseFireStoreDataSourceImp: FirebaseFireStoreDataSourceImp
    ): FirebaseFireStoreDataSource
}