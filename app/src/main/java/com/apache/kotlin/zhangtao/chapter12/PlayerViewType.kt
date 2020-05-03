package com.apache.kotlin.zhangtao.chapter12

/**
 * Created by Jerry on 2020-04-27.
 */
sealed class PlayerViewType {
    object GREEN:PlayerViewType()
    object BLUE:PlayerViewType()
    class VIP(val title:String? = null, val message:String? = null):PlayerViewType()
}



fun getPlayerView(type: PlayerViewType) = when (type) {
    PlayerViewType.GREEN -> GreenPlayerView()
    PlayerViewType.BLUE -> BluePlayerView()
    is PlayerViewType.VIP -> VIPPlayerView(type.title, type.message)
}