package com.apache.kotlin.zhangtao.chapter12

/**
 * Created by Jerry on 2020-04-27.
 */
interface PlayerView {
    fun showView()

    fun getPlayButton()
}



class MediaPlayerView(playerView: PlayerView):PlayerView by playerView