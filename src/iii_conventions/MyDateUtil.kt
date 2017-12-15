package iii_conventions

import iii_conventions.TimeInterval.*
import java.util.*

fun MyDate.nextDay() = addTimeIntervals(DAY, 1)

fun MyDate.addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)
    when (timeInterval) {
        TimeInterval.DAY -> c.add(Calendar.DAY_OF_MONTH, number)
        TimeInterval.WEEK -> c.add(Calendar.WEEK_OF_MONTH, number)
        TimeInterval.YEAR -> c.add(Calendar.YEAR, number)
    }
    return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))
}

fun MyDate.puls(timeInterval:TimeInterval):MyDate{
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)
    when (timeInterval) {
        TimeInterval.DAY -> c.add(Calendar.DAY_OF_MONTH, 1)
        TimeInterval.WEEK -> c.add(Calendar.WEEK_OF_MONTH, 1)
        TimeInterval.YEAR -> c.add(Calendar.YEAR, 1)
    }
    return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))
}