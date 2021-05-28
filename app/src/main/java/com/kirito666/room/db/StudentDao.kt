package com.kirito666.room.db

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE


@Dao
interface StudentDao {
    @Insert(onConflict = REPLACE)
    fun insert(Student: Student): Long

    @get:Query("SELECT COUNT(*) from Student")
    val itemsCount: LiveData<Int>

    @get:Query("SELECT * from Student")
    val allStudent: LiveData<List<Student>>

    @Query("SELECT * FROM student WHERE id = :id ")
    fun getById(id: Int): LiveData<Student>

    @Delete
    fun delete(student: Student)

    @Update
    fun update(vararg student: Student)
}