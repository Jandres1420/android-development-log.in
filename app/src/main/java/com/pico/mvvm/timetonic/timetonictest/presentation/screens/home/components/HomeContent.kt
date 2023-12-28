package com.pico.mvvm.timetonic.timetonictest.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pico.mvvm.timetonic.timetonictest.domain.model.home.Book
import com.pico.mvvm.timetonic.timetonictest.ui.theme.Pink40

@Composable
fun HomeContent(books: List<Book>) {

    LazyColumn(
        modifier = Modifier.fillMaxWidth().background(Pink40)
    ) {
        items(items = books) { book ->
            BookCard(book)
        }
    }
}