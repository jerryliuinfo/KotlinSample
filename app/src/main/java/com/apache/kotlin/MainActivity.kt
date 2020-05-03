package com.apache.kotlin

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.apache.kotlin.api.Api
import com.apache.kotlin.arraylist.ArrayListDemo
import com.apache.kotlin.bean.Repo
import com.apache.kotlin.collections.CollectionDemo
import com.apache.kotlin.construto.SIZE_URL
import com.apache.kotlin.construto.StaticConstantDemo2
import com.apache.kotlin.construto.printUrl
import com.apache.kotlin.coroutines.CoroutinesDay1
import com.apache.kotlin.coroutines.CoroutinesDay2
import com.apache.kotlin.domain_func.*
import com.apache.kotlin.function_simplify.FunctionSimplifyDemo
import com.apache.kotlin.lamada.LamadaDemo
import com.apache.kotlin.sequens.SequencesDemo
import com.apache.kotlin.stringformat.StringFormatDemo
import com.apache.kotlin.util.LogUtils
import com.apache.kotlin.zhangtao.chapter02.ObjectDemo
import com.apache.kotlin.zhangtao.chapter09.StaticMethodDemo
import com.apache.kotlin.zhangtao.chapter11.DataClass
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open  class MainActivity : AppCompatActivity(),IUser {
    override fun getUser(): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    lateinit var textView:TextView

     var name:String? = null

    get() {
        return field + " nb"
    }
    set(value) {
        field = "Cute " + value
    }

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         textView = findViewById(R.id.textView)
        name = "Jerry"
         LogUtils.d("name is: $name")
         //val textView:TextView = findViewById(R.id.text)

//        var a:Int = 1 //unbox
//        var b:Int? = 2 //box
//        var list:List<Int> = listOfNotNull(1,2,3)
//        print("value:$list")
         //var array:IntArray = intArrayOf(1,2)
         var user = User( "Alyson")
         LogUtils.d(user.name)
         LogUtils.d(Sample.name)
         Sample.method()

         var listener = object :ViewPager.SimpleOnPageChangeListener(){
             override fun onPageSelected(position: Int) {
                 super.onPageSelected(position)

             }
         }
         LogUtils.d(PartStatic.c)
         println()
         topLevelFunction()
         com.apache.kotlin.domain_func2.topLevelFunction()

         var collectionDemo = CollectionDemo()
         collectionDemo.test()

         var sequencesDemo = SequencesDemo()
         sequencesDemo.test()

        LogUtils.d( StaticConstantDemo2.SITE)
         StaticConstantDemo2.printSite()
         LogUtils.d("top declaration: $SIZE_URL")
         printUrl()

        // PrimaryConstructorDemo2() //构造器私有不允许访问
         val functionSimplifyDemo = FunctionSimplifyDemo()
         functionSimplifyDemo.sayHello("Jerry")
         functionSimplifyDemo.sayHello()
         functionSimplifyDemo.sayHello2(age = 20,isStudent = false)


         val lamadaDemo = LamadaDemo()
         lamadaDemo.test()

         textView.setOnClickListener({v:View ->
             swtichToNextPage() }
         )

         textView.setOnClickListener{v:View ->
             swtichToNextPage()
         }
         ObjectDemo.sayMessage(".kt调用")

         StaticMethodDemo.isEmpty("")

         val dataClass = DataClass(1,"Jerry")
         println(dataClass.toString())





         val retrofit = Retrofit.Builder().baseUrl("https://api.github.com/")
             .baseUrl("https://api.github.com/")
             .addConverterFactory(GsonConverterFactory.create())
             .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
             .build()
         val api = retrofit.create(Api::class.java);
         api.listRepos("rengwuxian")
             .enqueue(object : Callback<List<Repo>?> {
                 override fun onFailure(call: retrofit2.Call<List<Repo>?>, t: Throwable) {
                     textView?.setText("load error")
                     LogUtils.d("onFailure: error textView:$textView")

                 }

                 override fun onResponse(
                     call: retrofit2.Call<List<Repo>?>,
                     response: Response<List<Repo>?>
                 ) {
                     LogUtils.d("onResponse: ${response.body()?.get(0)?.name}textView:$textView")

                     textView?.setText(response.body()?.get(0)?.name)

                 }


             })

     }

    fun swtichToNextPage(){

    }






}
