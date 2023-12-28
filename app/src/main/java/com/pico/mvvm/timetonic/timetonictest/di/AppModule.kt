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
import com.pico.mvvm.timetonic.timetonictest.data.repository.HomeRepositoryImpl
import com.pico.mvvm.timetonic.timetonictest.domain.repository.HomeRepository
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.home.GetAllBooksCase
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.home.HomeUseCases
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in.CreateOAuthKey
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in.CreateSessKeyCase
import com.pico.mvvm.timetonic.timetonictest.presentation.navigation.AppScreen
/**
 *  here we daggerHilt module that provides information to the other classes
 */
@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    /**
     *  Provide all the logInUseCases specifically with the corresponding repository and actions
     *  @param repository: LogInRepository
     */
    @Provides
    fun provideLogInUseCases(repository: LogInRepository) = LogInUseCases(
        createAppKeyCase = CreateAppKeyCase(repository),
        createOAuthKey = CreateOAuthKey(repository),
        createSessKeyCase = CreateSessKeyCase(repository)
    )
    /**
     *  Provide all the provideHomeUseCases specifically with the corresponding repository and action
     *  @param repository: HomeRepository
     */
    @Provides
    fun provideHomeUseCases(repository: HomeRepository) = HomeUseCases(
        getAllBooksCase = GetAllBooksCase(repository)
    )

    /**
     *  Provide the retrofit instance with the url that is gonna be used for the api calls
     */
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URLTIMETONIC)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     *  Provide the apiService instance with retrofit, the one that is gonna be in charge for the use of the api calls
     *   @param retrofit:Retrofit
     */
    @Provides
    @Singleton
    fun provideCreateAppKey(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
    /**
     *  provide the instance LogInRepository and create the instance of the implementation of this interface where is gonna be used
     *  the apiService
     *  @param apiService
     */
    @Provides
    @Singleton
    fun provideLogInRepository(apiService: ApiService): LogInRepository {
        return LogInRepositoryImpl(apiService)
    }

    /**
     *  provide the instance HomeRepository and create the instance of the implementation of this interface where is gonna be used
     *  the apiService
     *  @param apiService
     */
    @Provides
    @Singleton
    fun provideHomeRepository(apiService: ApiService): HomeRepository {
        return HomeRepositoryImpl(apiService)
    }

}