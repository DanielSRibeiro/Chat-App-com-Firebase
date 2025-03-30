package com.example.realtimechat.data.domain.usecase.di

import com.example.realtimechat.data.domain.usecase.SignUpUserUseCase
import com.example.realtimechat.data.domain.usecase.SignUpUserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindSignUpUserUseCase(
        useCase: SignUpUserUseCaseImpl
    ): SignUpUserUseCase

}