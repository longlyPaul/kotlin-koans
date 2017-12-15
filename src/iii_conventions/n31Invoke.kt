package iii_conventions

import util.TODO


class Invokable(var count:Int = 0)

operator fun Invokable.invoke(): Invokable{
    this.count++
    return this
}

fun Invokable.getNumberOfInvocations(): Int = this.count

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
