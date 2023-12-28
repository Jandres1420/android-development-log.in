package com.pico.mvvm.timetonic.timetonictest.domain.model

import com.google.gson.Gson


data class AllBooksReq(
    val version: String,
    val o_u: String,
    val u_c: String,
    val sesskey: String,
    val req: String,
){
    /**
     *  Herewe use Gson to convert a AllBooksReq into a string
     *  @return String
     */
    fun toJson(): String = Gson().toJson(AllBooksReq(version,
        o_u,
        u_c,
        sesskey,
        req))

    companion object {

        /**
         *  Herewe use Gson to convert a String  into a AllBooksReq class
         *  @return AllBooReq
         */
        fun fromJson(data: String): AllBooksReq = Gson().fromJson(data, AllBooksReq::class.java)
    }
}

