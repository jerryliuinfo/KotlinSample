package com.apache.kotlin.zhangtao.chapter12

/**
 * Created by Jerry on 2020-04-27.
 */
fun main(args: Array<String>) {
    var user = User(1,"name",PlayerViewType.VIP("vip播放器标题","vip播放器内容"))

     user = User(1,"name")

    PlayerUI.get().showPlayer(user)
}