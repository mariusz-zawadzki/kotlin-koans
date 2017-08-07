package i_introduction._4_Lambdas

import util.TODO
import util.doc4

fun example() {

    val sum = { x: Int, y: Int -> x + y }
    val square: (Int) -> Int = { x -> x * x }

    sum(1, square(2)) == 5
}

fun todoTask4(collection: Collection<Int>): Boolean {
    val any42: (Int) -> Boolean = {x: Int -> x%42 == 0}

    return collection.find(any42)!=null
}

fun task4(collection: Collection<Int>): Boolean = todoTask4(collection)