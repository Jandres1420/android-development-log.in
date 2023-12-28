package com.pico.mvvm.timetonic.timetonictest.domain.use_cases.home

import com.pico.mvvm.timetonic.timetonictest.domain.repository.HomeRepository

class GetAllBooksCase constructor(private val repository: HomeRepository) {

    suspend operator fun invoke(version: String,
                                o_u: String,
                                u_c: String,
                                sesskey: String,
                                req: String) = repository.gellAllBooks(version,o_u,u_c,sesskey,req)
}