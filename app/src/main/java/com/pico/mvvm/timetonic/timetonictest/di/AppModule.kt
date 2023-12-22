package com.pico.mvvm.timetonic.timetonictest.di

import com.pico.mvvm.timetonic.timetonictest.data.repository.LogInRepositoryImpl
import com.pico.mvvm.timetonic.timetonictest.domain.repository.LogInRepository
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in.CreateAppKeyCase
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in.LogInUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideLogInRepository(impl: LogInRepositoryImpl): LogInRepository = impl

    @Provides
    fun provideLogInUseCases(repository: LogInRepository) = LogInUseCases(
       createAppKeyCase = CreateAppKeyCase(repository)
    )

}