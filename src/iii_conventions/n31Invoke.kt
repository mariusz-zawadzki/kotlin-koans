package iii_conventions

import util.TODO


class Invokable (var invocations: Int = 0 ){

    operator fun invoke(): Invokable = Invokable(invocations +1)

    fun  getNumberOfInvocations(): Int = invocations

}
fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change the class 'Invokable' to count the number of invocations:
        for 'invokable()()()()' it should be 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
//    todoTask31()
    return invokable()()()().getNumberOfInvocations()
}
