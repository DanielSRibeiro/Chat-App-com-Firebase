package com.example.realtimechat.data.repository.di

import com.example.realtimechat.data.repository.authentication.FirebaseAuthenticationRepository
import com.example.realtimechat.data.repository.authentication.FirebaseAuthenticationRepositoryImp
import com.example.realtimechat.data.repository.firestore.FirebaseFireStoreRepository
import com.example.realtimechat.data.repository.firestore.FirebaseFireStoreRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindFirebaseAuthenticationRepository(
        firebaseAuthenticationRepositoryImp: FirebaseAuthenticationRepositoryImp
    ): FirebaseAuthenticationRepository

    @Binds
    fun bindFireStoreRepository(
        firebaseFireStoreRepositoryImp: FirebaseFireStoreRepositoryImp
    ): FirebaseFireStoreRepository
}