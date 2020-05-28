package com.apache.kotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.apache.kotlin.hencoder.chapter01.User

/**
 * Created by Jerry on 2020-04-18.
 */
 class NewActivity :AppCompatActivity(R.layout.activity_main){
    lateinit var view:View


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user: User = User()
        println(user.name?.length)
        //println(user.name!!.length)

    }



}