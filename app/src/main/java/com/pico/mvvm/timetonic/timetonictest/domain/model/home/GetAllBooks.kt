package com.pico.mvvm.timetonic.timetonictest.domain.model.home

data class GetAllBooks(
    val status: String,
    val sstamp: Long,
    val allBooks: AllBooks,
    val createdVNB: String,
    val req: String
)
