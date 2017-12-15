package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int):Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
       return when{
           year != other.year -> year - other.year
           month != other.month -> month - other.month
           else -> dayOfMonth - other.dayOfMonth
       }
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this,other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate):ClosedRange<MyDate>
        ,Iterable<MyDate>{
    override fun iterator(): Iterator<MyDate> = object : Iterator<MyDate> {
        var current: MyDate = start
        override fun next(): MyDate {
            val result = current
            current = current.addTimeIntervals(TimeInterval.DAY, 1)
            return result
        }
        override fun hasNext(): Boolean = current <= endInclusive
    }

    override fun contains(d: MyDate):Boolean = start <= d && endInclusive >= d
}

class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {
    var current: MyDate = dateRange.start
    override fun next(): MyDate {
        val result = current
        current = current.addTimeIntervals(TimeInterval.DAY, 1)
        return result
    }
    override fun hasNext(): Boolean = current <= dateRange.endInclusive
}

fun DateRange.step(step:Int):IntProgression{
    if (step <= 0) throw IllegalArgumentException("Step must be positive, was: $step")
    return IntProgression.fromClosedRange(start.dayOfMonth, endInclusive.dayOfMonth,
            if (step > 0) step else -step)
}

class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)

operator fun MyDate.plus(timeInterval: TimeInterval) = addTimeIntervals(timeInterval,1);

operator fun TimeInterval.times(fold:Int) = RepeatedTimeInterval(this,fold)

operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval) = addTimeIntervals(repeatedTimeInterval.ti,repeatedTimeInterval.n)
