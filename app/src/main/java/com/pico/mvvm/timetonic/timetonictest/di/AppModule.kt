package com.pico.mvvm.timetonic.timetonictest.di

import com.pico.mvvm.timetonic.timetonictest.core.Constants
import com.pico.mvvm.timetonic.timetonictest.data.repository.LogInRepositoryImpl
import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateAppKey
import com.pico.mvvm.timetonic.timetonictest.domain.repository.ApiService
import com.pico.mvvm.timetonic.timetonictest.domain.repository.LogInRepository
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in.CreateAppKeyCase
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in.LogInUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.pico.mvvm.timetonic.timetonictest.core.Constants.URLTIMETONIC
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in.CreateOAuthKey
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in.CreateSessKeyCase

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Provides
    fun provideLogInUseCases(repository: LogInRepository) = LogInUseCases(
        createAppKeyCase = CreateAppKeyCase(repository),
        createOAuthKey = CreateOAuthKey(repository),
        createSessKeyCase = CreateSessKeyCase(repository)
    )
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URLTIMETONIC)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCreateAppKey(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideLogInRepository(apiService: ApiService): LogInRepository {
        return LogInRepositoryImpl(apiService)
    }

}