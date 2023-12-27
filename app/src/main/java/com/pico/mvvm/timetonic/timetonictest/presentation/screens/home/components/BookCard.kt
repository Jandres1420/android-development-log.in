package com.pico.mvvm.timetonic.timetonictest.presentation.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pico.mvvm.timetonic.timetonictest.domain.model.home.Book

@Composable
fun BookCard(book: Book) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column {

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp), 
                model = book.ownerPrefs.oCoverImg,
                contentDescription = "Book Image")
            Text(text = book.description?:"")
        }
    }
}