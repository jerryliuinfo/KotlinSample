package com.apache.kotlin.zhangtao.chapter12

import android.icu.text.CaseMap

/**
 * Created by Jerry on 2020-04-27.
 */
val TITLE = "播放器标题"
val MESSAGE = "播放器消息"

class VIPPlayerView (var title:String?, var message:String?):PlayerView{
    init {
        println("主构造方法")
        title = title?: TITLE
        message = message?: MESSAGE
    }

    constructor():this(TITLE, MESSAGE)
    constructor(message:String?): this(TITLE,message)

    override fun showView() {
        println("Show vip view")

    }

    override fun getPlayButton() {
        println("VIP button")
    }

}