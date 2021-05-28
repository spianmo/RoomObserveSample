package com.kirito666.room

import android.os.Bundle
import com.kirito666.room.db.AppDatabase
import com.kirito666.room.db.Student
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : BaseActivity() {

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        ktxRunOnUi { throwable.toast(this) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener {
            GlobalScope.launch(errorHandler) {
                withContext(Dispatchers.IO) {
                    AppDatabase.getInstance(applicationContext)
                        .sampleDao()
                        .insert(Student("Kirito666", "Software2036", 22))
                }
            }
        }

        button2.setOnClickListener {
            GlobalScope.launch(errorHandler) {
                withContext(Dispatchers.IO) {
                    AppDatabase.getInstance(applicationContext)
                        .sampleDao()
                        .delete(Student("Shinonon66", "Software2036", 21, 1))
                }
            }
        }

        button3.setOnClickListener {
            GlobalScope.launch(errorHandler) {
                withContext(Dispatchers.IO) {
                    AppDatabase.getInstance(applicationContext)
                        .sampleDao()
                        .update(Student("Shinonon66", "Software2036", 21, 1))
                }
            }
        }

        button4.setOnClickListener {
            GlobalScope.launch(errorHandler) {
                withContext(Dispatchers.IO) {
                    AppDatabase.getInstance(applicationContext)
                        .sampleDao()
                        .getById( 1)
                }
            }
        }

        AppDatabase.getInstance(applicationContext).sampleDao().allStudent.observe(
            this, { counter ->
                tv_result.text = counter.toString()
            })

    }
}