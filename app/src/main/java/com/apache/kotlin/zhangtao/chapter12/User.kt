package com.apache.kotlin.zhangtao.chapter12

/**
 * Created by Jerry on 2020-04-27.
 */
data class User(val id:Int, val name:String, val  playerType:PlayerViewType = PlayerViewType.BLUE)