package com.example.myapplication.roomdatabase.papaya

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {

    @Insert
    suspend fun insertStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)

    @Query("SELECT * FROM student")
    fun getAllStudent(): LiveData<List<Student>>

    @Query("DELETE FROM student where id=:id")
    fun deleteById(id:Int)
}
