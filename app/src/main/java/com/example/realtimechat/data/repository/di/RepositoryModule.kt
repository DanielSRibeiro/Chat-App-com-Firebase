package com.example.realtimechat.data.repository.di

import com.example.realtimechat.data.repository.FirebaseAuthenticationDataSource
import com.example.realtimechat.data.repository.FirebaseAuthenticationDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsFirebaseAuthenticationDataSource(
        firebaseAuthenticationDataSourceImpl: FirebaseAuthenticationDataSourceImpl
    ): FirebaseAuthenticationDataSource
}