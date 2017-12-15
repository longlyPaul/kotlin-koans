package iv_properties

import util.TODO
import java.util.*
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class LazyProperty(val initializer: () -> Int) {
    val lazy: Int? = null
    get() {
        if (field == null) field = initializer()
        return field
    }
}

class ObserverProperty{
    var ob:String by Delegates.observable("NUlL") { p,o, arg -> println("$o -> $arg") }

}

fun todoTask33(): Nothing = TODO(
    """
        Task 33.
        Add a custom getter to make the 'lazy' val really lazy.
        It should be initialized by the invocation of 'initializer()'
        at the moment of the first access.
        You can add as many additional properties as you need.
        Do not use delegated properties yet!
    """,
    references = { LazyProperty({ 42 }).lazy }
)

fun main(args: Array<String>) {
    var observerProperty = ObserverProperty()
    observerProperty.ob = "12"
    observerProperty.ob = "yes"
    observerProperty.ob = "yes2"
}
