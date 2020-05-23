package com.apache.kotlin

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible


open  class MainActivity : AppCompatActivity(R.layout.activity_main) {

    lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        textView.setOnClickListener(fun (v: View):Unit{

        })

        textView.setOnClickListener({ v: View ->

        })

        //如果lambda 是函数的最后一个参数，可以把lambda写在括号的外面，变成
        textView.setOnClickListener(){ v: View ->

        }

        //如果lamada 是 函数唯一的参数，可以直接把括号去了，变成
        textView.setOnClickListener{ v: View ->

        }

        //Kotlin对于唯一的参数有默认的名字:it
        textView.setOnClickListener{
        }
    }




}
