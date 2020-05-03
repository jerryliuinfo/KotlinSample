package com.apache.kotlin.zhangtao.chapter11

/**
 * Created by Jerry on 2020-04-27.
 */
enum class Command{
    A,B,C
}

fun exec(command: Command) = when(command){
    Command.A -> {}
    Command.B -> {}
    Command.C -> {}
}