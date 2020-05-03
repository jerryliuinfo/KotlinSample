package com.apache.kotlin.zhangtao.chapter12

/**
 * Created by Jerry on 2020-04-27.
 */
class GreenPlayerView:PlayerView{
    override fun getPlayButton() {
        println("显示绿色的button")
    }

    override fun showView() {
        println("Show green view")

    }
}