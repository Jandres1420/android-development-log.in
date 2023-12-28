package com.pico.mvvm.timetonic.timetonictest.domain.repository

import com.pico.mvvm.timetonic.timetonictest.domain.model.AllBooksReq
import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateAppKey
import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateSessKey
import com.pico.mvvm.timetonic.timetonictest.domain.model.LogIn
import com.pico.mvvm.timetonic.timetonictest.domain.model.home.GetAllBooks
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("createAppKey")
    suspend fun getAppKey(
        @Query("version") version: String,
        @Query("req") req: String,
        @Query("appname") appName: String,
    ): CreateAppKey

    @POST("logIn")
    suspend fun login(
        @Query("version") version: String,
        @Query("login") logIn: String,
        @Query("pwd") pwd: String,
        @Query("appkey") appKey: String,
        @Query("req") req: String,
    ): LogIn

    @POST("createSessKey")
    suspend fun createSessKey(
        @Query("version") version: String,
        @Query("req") req: String,
        @Query("o_u") o_u: String,
        @Query("u_c") u_c: String,
        @Query("oauthkey") oauthkey: String,
    ): CreateSessKey

    @POST("gellAllBooks")
    suspend fun gellAllBooks(
        @Query("version") version: String,
        @Query("o_u") o_u: String,
        @Query("u_c") u_c: String,
        @Query("sesskey") sesskey: String,
        @Query("req") req: String,
    ): GetAllBooks


}