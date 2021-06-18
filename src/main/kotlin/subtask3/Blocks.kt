package subtask3

import java.time.LocalDate
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {

        var resultString = ""
        var resultInt = 0
        var resultDate = LocalDate.parse("0000-01-01")

        blockA.forEach { i ->
            if (i != null) {
                if (i::class == blockB && blockB == String()::class) {
                    resultString += i
                }
                if (i::class == blockB && blockB == Int::class) {
                    resultInt += i as Int
                }
                if (i::class == blockB && blockB == LocalDate::class) {


                    val iDate = i as LocalDate

                    if (resultDate < iDate) {
                        resultDate = iDate
                    }
                }
            }
        }

        return when(blockB) {
            String()::class -> resultString
            Int::class -> resultInt
            LocalDate::class -> "${resultDate.dayOfMonth}.${resultDate.monthValue}.${resultDate.year}"
            else -> "Nothing"
        }
    }
}
