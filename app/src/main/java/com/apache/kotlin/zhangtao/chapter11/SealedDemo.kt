package com.apache.kotlin.zhangtao.chapter11

/**
 * Created by Jerry on 2020-04-27.
 */
sealed class SuperCommand{
    object A:SuperCommand()
    object B:SuperCommand()
    object C:SuperCommand()
    class E(var id:Int):SuperCommand()
}

fun exec(command: SuperCommand) = when(command){
    SuperCommand.A -> {}
    SuperCommand.B -> {}
    SuperCommand.C -> {}
    is SuperCommand.E -> {}
}