package com.pico.mvvm.timetonic.timetonictest.domain.model.home

data class AllBooks(
    val nbBooks: Int,
    val nbContacts: Int,
    val contacts: List<Contacts>,
    val books: List<Book>,
)
