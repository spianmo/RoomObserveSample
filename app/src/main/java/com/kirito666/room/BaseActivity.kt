package com.kirito666.room

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    private val handler = Handler(Looper.getMainLooper())

    protected fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
        return Toast.makeText(context, this.toString(), duration).apply { show() }
    }

    protected fun ktxRunOnUi(block: () -> Unit) {
        handler.post {
            block()
        }
    }
}