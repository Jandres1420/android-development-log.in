package com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in

import com.pico.mvvm.timetonic.timetonictest.domain.repository.LogInRepository
/**
 *  here we CreateSessKeyCase with a suspend operator for being asynchronous directly with the LogInrepository
 *  its suspend because its an asynchronous called
 */
class CreateSessKeyCase constructor(private val repository: LogInRepository) {
    suspend operator fun invoke(
        version: String,
        req: String,
        o_u: String,
        u_c: String,
        oauthkey: String
    ) =
        repository.createSessKey(version, req, o_u, u_c, oauthkey)

}