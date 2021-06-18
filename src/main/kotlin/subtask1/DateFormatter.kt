package subtask1

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale


class DateFormatter {

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {

        var date = "$day "
        var isCorrect = true

        if (day.toInt() < 1 || day.toInt() > 31) {
            isCorrect = false
        }

        if (year.toInt() % 4 !=0 && day.toInt() > 28) {
            isCorrect = false
        }

        when(month.toInt()) {
            1 -> {
                date += "января, "

            }
            2 -> {
                date += "февраля, "
            }
            3 -> {
                date += "марта, "
            }
            4 -> {
                date += "апреля, "
            }
            5 -> {
                date += "мая, "
            }
            6 -> {
                date += "июня, "
            }
            7 -> {
                date += "июля, "
            }
            8 -> {
                date += "августа, "
            }
            9 -> {
                date += "сентября, "
            }
            10 -> {
                date += "октября, "
            }
            11 -> {
                date += "ноября, "
            }
            12 -> {
                date += "декабря, "
            }
            else -> {
                isCorrect = false
            }
        }

        if (isCorrect) {
            val dayRus = getWeekDayName("$year-$month-$day")
            if (dayRus == ""){
                date = "Такого дня не существует"
            } else {
                date += dayRus
            }
        } else {
            date = "Такого дня не существует"
        }
        return date
    }

    private fun getWeekDayName(s: String?): String {
        val dtfInput = DateTimeFormatter.ofPattern("u-M-d", Locale.ENGLISH)
        return when (LocalDate.parse(s, dtfInput).dayOfWeek.getDisplayName(
            TextStyle.FULL,
            Locale.ENGLISH
        )) {
            "Sunday" -> {
                "воскресенье"
            }
            "Monday" -> {
                "понедельник"
            }
            "Tuesday" -> {
                "вторник"
            }
            "Wednesday" -> {
                "среда"
            }
            "Thursday" -> {
                "четверг"
            }
            "Friday" -> {
                "пятница"
            }
            "Saturday" -> {
                "суббота"
            }
            else -> {
                ""
            }
        }
    }
}
