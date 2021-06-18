package subtask2

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        val aList = mutableListOf<String>()
        val bList = mutableListOf<String>()
        val bListMutable = mutableListOf<String>()

        for (i in a.toLowerCase()) {
            aList.add(i.toString())
        }

        for (i in b.toLowerCase()) {
            bList.add(i.toString())
            bListMutable.add(i.toString())
        }

        val leng = bList.size
        var index = 0

        for (i in a.toLowerCase()) {
            if (index < leng) {
                if (i.toString() == bListMutable[index]) {
                    bList.remove(i.toString())
                    index += 1
                }
            }
        }

        if (bList.isEmpty()) {
            return "YES"
        }
        return "NO"
    }
}
