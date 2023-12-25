package com.pico.mvvm.timetonic.timetonictest.domain.model

import com.google.gson.Gson


data class AllBooksReq(
    val version: String,
    val o_u: String,
    val u_c: String,
    val sesskey: String,
    val req: String,
){
    fun toJson(): String = Gson().toJson(AllBooksReq(version,
        o_u,
        u_c,
        sesskey,
        req))

    companion object {
        fun fromJson(data: String): AllBooksReq = Gson().fromJson(data, AllBooksReq::class.java)
    }
}

