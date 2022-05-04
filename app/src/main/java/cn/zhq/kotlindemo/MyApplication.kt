package cn.zhq.kotlindemo

import android.app.Application
import android.content.Context

class MyApplication : Application() {

    companion object {
        lateinit var context: Context
        const val TOKEN = "pssY4yVGPRXjhA1a"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}