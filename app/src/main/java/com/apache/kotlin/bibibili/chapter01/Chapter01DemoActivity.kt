package com.apache.kotlin.bibibili.chapter01

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.apache.kotlin.R
import com.apache.kotlin.bibibili.chapter02.topLevelFunction

/**
 * Created by Jerry on 2020-04-18.
 */
 class Chapter01DemoActivity :AppCompatActivity(R.layout.activity_main){
    lateinit var textview:View


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        textview = findViewById(R.id.textView)


    }

    private fun print(view: View?){
        println(view?.id)
    }



}