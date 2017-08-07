package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val compareList = listOf(year.compareTo(other.year),
                month.compareTo(other.month),
                dayOfMonth.compareTo(other.dayOfMonth))
        val firstOrNull = compareList.filter { it != 0 }.firstOrNull()
        return if (firstOrNull != null) firstOrNull else 0;
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)
operator fun MyDate.plus(interval: TimeInterval) =  addTimeIntervals(interval, 1)
operator fun MyDate.plus(interval: MultipleTimeInterval) =  addTimeIntervals(interval.interval, interval.times)

data class MultipleTimeInterval(val interval: TimeInterval, val times: Int)

operator fun TimeInterval.times(times: Int) = MultipleTimeInterval(this, times)


enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate){
    operator fun contains(myDate: MyDate): Boolean = (start <= myDate) && (myDate <= endInclusive)
}

class MyDateRangeIterator(val range: DateRange) : Iterator<MyDate>{

    var currentDate: MyDate= range.start;

    override fun hasNext(): Boolean {
        return currentDate <= range.endInclusive;
    }

    override fun next(): MyDate {
        val returnDate = currentDate
        currentDate = currentDate.nextDay()
        return returnDate;
    }
}

operator fun DateRange.iterator() : Iterator<MyDate>  = MyDateRangeIterator(this)
