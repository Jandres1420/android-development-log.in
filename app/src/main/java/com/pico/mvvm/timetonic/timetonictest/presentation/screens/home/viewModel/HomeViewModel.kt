package com.pico.mvvm.timetonic.timetonictest.presentation.screens.home.viewModel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pico.mvvm.timetonic.timetonictest.core.Constants
import com.pico.mvvm.timetonic.timetonictest.domain.model.AllBooksReq
import com.pico.mvvm.timetonic.timetonictest.domain.model.Response
import com.pico.mvvm.timetonic.timetonictest.domain.model.home.Book
import com.pico.mvvm.timetonic.timetonictest.domain.model.home.GetAllBooks
import com.pico.mvvm.timetonic.timetonictest.domain.model.home.OwnerPrefs
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.home.HomeUseCases
import com.pico.mvvm.timetonic.timetonictest.utils.EncryptionUtil
import com.pico.mvvm.timetonic.timetonictest.utils.SharedPreferencesUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject
/**
 *  Here we have all the logic of the HomeScreen
 * @param homeUseCases: LogInUseCases using daggerHilt
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCases: HomeUseCases,
    @ApplicationContext private val context: Context
) : ViewModel() {

    var allBooksReq by mutableStateOf<AllBooksReq?>(null)
        private set

    var getAllBooksResponse by mutableStateOf<Response<GetAllBooks>?>(null)
        private set

    var books by mutableStateOf<List<Book>>(listOf())
        private set

    init {
        getEncryptedInfo()
        getAllBooks()
    }

    /**
     *  Here we get the encrypted info with SharedPrefereneUtil and saving it in allBooksReq
     */
    private fun getEncryptedInfo() {
        val allBooksReqString =
            SharedPreferencesUtil.readFromSharedPreferences(context, "sessionBooks", "")
        allBooksReq = AllBooksReq.fromJson(EncryptionUtil.decrypt(allBooksReqString))
    }

    /**
     *  Here we get All the books with an asynchronous called with Retrofit using the homeUseCases.getAllBooksCase
     */
    fun getAllBooks() = viewModelScope.launch {
        getAllBooksResponse = Response.Loading
        try {
            val result = homeUseCases.getAllBooksCase(
                allBooksReq!!.version,
                allBooksReq!!.o_u,
                allBooksReq!!.u_c,
                allBooksReq!!.sesskey,
                allBooksReq!!.req
            )
            getAllBooksResponse = Response.Success(result)
            books = (getAllBooksResponse as? Response.Success<GetAllBooks>)!!.data.allBooks.books
            convertImageURL()
        } catch (e: Exception) {
            e.printStackTrace()
            getAllBooksResponse = Response.Failure(e)
        }
    }
    /**
     *  Here we convert from each book the OwnerPrefs.oCoverImg into the correct url
     */
    fun convertImageURL(){
        var ownerPrefs:OwnerPrefs
        books.forEach{ book: Book ->
            ownerPrefs = book.ownerPrefs
            ownerPrefs.oCoverImg = Constants.URLTIMETONICIMAGE + ownerPrefs.oCoverImg.replace("\\","")
            ownerPrefs.oCoverImg = ownerPrefs.oCoverImg.replace("/live","")
            book.ownerPrefs = ownerPrefs
        }
    }

}