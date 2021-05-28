package com.kirito666.room.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student (
    var name: String = "",
    var clazz: String = "",
    var age: Int = 0,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)