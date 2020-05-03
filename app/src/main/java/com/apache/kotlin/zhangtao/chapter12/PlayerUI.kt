package com.apache.kotlin.zhangtao.chapter12

/**
 * Created by Jerry on 2020-04-27.
 */
class PlayerUI private constructor(){

    companion object{
        fun get():PlayerUI{
            return Holder.instance
        }
    }

    private object Holder{
        val instance = PlayerUI()
    }

    fun showPlayer(user:User){
        val playerView:PlayerView = MediaPlayerView(getPlayerView(user.playerType))
        playerView.showView()
    }
}