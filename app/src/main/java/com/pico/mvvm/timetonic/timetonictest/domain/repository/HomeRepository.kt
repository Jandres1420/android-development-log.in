package com.pico.mvvm.timetonic.timetonictest.domain.repository

import com.pico.mvvm.timetonic.timetonictest.domain.model.AllBooksReq
import retrofit2.http.Query

interface HomeRepository {
    suspend fun gellAllBooks(
        version: String, o_u: String, u_c: String, sesskey: String,
        req: String,
    ): AllBooksReq
}