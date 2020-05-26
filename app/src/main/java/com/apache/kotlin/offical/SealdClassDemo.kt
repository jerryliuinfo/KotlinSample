package com.apache.kotlin.offical

/**
 * Created by Jerry on 2020-05-25.
 * 密封类: 受限的类继承结构(有限集合的类型,不能有任何其他类型)
 * 在某种意义上,密封类就是扩展的枚举类enum(枚举类的值集合也是受限)
不同之处:
枚举类的每个枚举常量只存在一个实例,
密封类的一个子类可以有可包含状态的多个实例!
密封类的所有子类都必须与密封类在同一文件中,
密封类子类的子类(间接继承者)可以放在任何位置,无需在同一个文件中!
 * 密封类的好处在于:使用when表达式,如果能覆盖所有情况,就无需再添加else子句
 */
sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

fun eval(expr: Expr): Double = when(expr) {
    is Const -> expr.number
    is Sum -> eval(
        expr.e1
    ) + eval(expr.e2)
    NotANumber -> Double.NaN
    // the `else` clause is not required because we've covered all the cases
}

fun main() {
    println(
        eval(
            Const(
                2.0
            )
        )
    )
    println(
        eval(
            Sum(
                Const(3.0),
                Const(4.0)
            )
        )
    )
    println(eval(NotANumber))

}