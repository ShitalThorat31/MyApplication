package com.example.myapplication.roomdatabase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.myapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class LiveDataBase_Activity: AppCompatActivity() {
    private lateinit var bookDao: BookDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)

        val db = Room.databaseBuilder(
            applicationContext,
            BookDatabase::class.java, "book_database"
        ).build()

        bookDao = db.bookDao()
        testDB()

    }

    private fun testDB(){

        lifecycleScope.launch(Dispatchers.IO) {
            //Insert
            Log.i("MyTAG","*****     Inserting 3 Books     **********")
            bookDao.insertBook(Book(0,"Java","Alex"))
            bookDao.insertBook(Book(0,"PHP","Mike"))
            bookDao.insertBook(Book(0,"Kotlin","Amelia"))
            Log.i("MyTAG","*****     Inserted 3 Books       **********")

            //Query
            val books = bookDao.getAllBooks()
            //Log.i("MyTAG","*****   ${books.size} books there *****")
            for(book in books){
                Log.i("MyTAG","id: ${book.id} name: ${book.name} author: ${book.author}")
            }

            //Update
            Log.i("MyTAG","*****      Updating a book      **********")
            bookDao.updateBook(Book(1,"PHPUpdated","Mike"))
            //Query
            val books2 = bookDao.getAllBooks()
            Log.i("MyTAG","*****   ${books2.size} books there *****")
            for(book in books2){
                Log.i("MyTAG","id: ${book.id} name: ${book.name} author: ${book.author}")
            }

            //delete
            Log.i("MyTAG","*****       Deleting a book      **********")
            bookDao.deleteBook(Book(2,"Kotlin","Amelia"))
            //Query
            val books3 = bookDao.getAllBooks()
            Log.i("MyTAG","*****   ${books3.size} books there *****")
            for(book in books3){
                Log.i("MyTAG","id: ${book.id} name: ${book.name} author: ${book.author}")
            }
        }

    }
}
