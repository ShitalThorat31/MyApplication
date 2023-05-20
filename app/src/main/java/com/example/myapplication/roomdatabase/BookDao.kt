package com.example.myapplication.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BookDao
{
    @Insert
    suspend fun insertBook(book: Book)

    @Query("SELECT * FROM books_table")
    fun getAllBooks(): List<Book>

    @Update
    suspend fun updateBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)
}