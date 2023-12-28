package com.pico.mvvm.timetonic.timetonictest.presentation.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pico.mvvm.timetonic.timetonictest.domain.model.home.Book
/**
 *  Is the component that is responsabe for the UI of the card with the image and description
 *  @param book: Books
 */
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
                    .height(170.dp)
                    .padding(top = 10.dp),
                model = book.ownerPrefs.oCoverImg,
                contentDescription = "Book Image"
            )
            Text(
                text = book.description ?: "",
                color = Color.Black
            )
        }
    }
}