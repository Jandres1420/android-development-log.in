package com.pico.mvvm.timetonic.timetonictest.domain.use_cases.home

import com.pico.mvvm.timetonic.timetonictest.domain.repository.HomeRepository
/**
 *  here we GetAllBooks with a suspend operator for being asynchronous directly with the HomeRepository
 *  its suspend because its an asynchronous called
 */
class GetAllBooksCase constructor(private val repository: HomeRepository) {

    suspend operator fun invoke(version: String,
                                o_u: String,
                                u_c: String,
                                sesskey: String,
                                req: String) = repository.gellAllBooks(version,o_u,u_c,sesskey,req)
}