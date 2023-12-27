package com.pico.mvvm.timetonic.timetonictest.data.repository

import com.pico.mvvm.timetonic.timetonictest.domain.model.AllBooksReq
import com.pico.mvvm.timetonic.timetonictest.domain.model.home.GetAllBooks
import com.pico.mvvm.timetonic.timetonictest.domain.repository.ApiService
import com.pico.mvvm.timetonic.timetonictest.domain.repository.HomeRepository
import com.pico.mvvm.timetonic.timetonictest.domain.repository.LogInRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val apiService: ApiService):HomeRepository {
    override suspend fun gellAllBooks(
        version: String,
        o_u: String,
        u_c: String,
        sesskey: String,
        req: String
    ): GetAllBooks {
        return apiService.gellAllBooks(version,o_u,u_c,sesskey,req);
    }
}