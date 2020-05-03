package com.apache.kotlin

import android.app.Activity
import android.os.Bundle
import com.apache.kotlin.domain_func.User

/**
 * Created by Jerry on 2020-04-18.
 */
 class NewActivity :MainActivity(){
//    override fun test() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
    fun action() {}

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var user = User("Jerry")
        user.name = "zhangsan"
        print(user.name)

        var activity: Activity = NewActivity()
        if (activity is NewActivity){
            activity.action()
        }
        (activity as NewActivity).action()

        //
        (activity as? NewActivity)?.action()
    }



}