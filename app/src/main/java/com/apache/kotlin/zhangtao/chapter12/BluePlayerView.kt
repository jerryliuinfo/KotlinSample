package com.apache.kotlin.zhangtao.chapter12

/**
 * Created by Jerry on 2020-04-27.
 */
class BluePlayerView :PlayerView{
    override fun showView() {
        println("Show blue view")

    }

    override fun getPlayButton() {
        println("显示蓝色的button")
    }

}