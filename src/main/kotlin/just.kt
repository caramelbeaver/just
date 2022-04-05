const val MINUTE = 60
const val ONE_HOUR = 60*60
const val DAY = 24*60*60

fun main() {
    println(agoToText(5000))
}

fun agoToText (numberOfSeconds: Int): String {
    var secondsToConvert: Int = numberOfSeconds

    val days: Int = secondsToConvert / DAY
    secondsToConvert %= DAY

    val hours: Int = secondsToConvert / ONE_HOUR
    secondsToConvert %= ONE_HOUR

    val minutes: Int = secondsToConvert / MINUTE

    return "был(a) " + when {
        days > 3 -> "давно"
        days == 2 || days == 3 -> "вчера"
        days == 1 -> "сегодня"
        hours > 0 -> endingForm(hours, true)
        minutes >= 1 -> endingForm(minutes, false)
        else -> "только что"
    }
}

fun endingForm (number: Int, isHour: Boolean): String {
    val mod = number % 10
    return "$number " + when {
        (number > 10) && (number < 20) -> if (isHour) "часов" else "минут"
        mod == 1 -> if (isHour) "час" else "минуту"
        (mod > 1) && (mod < 5) -> if (isHour) "часа" else "минуты"
        else -> if (isHour) "часов" else "минут"
    } + " назад"
}
