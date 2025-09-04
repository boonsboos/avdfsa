package nl.boonsboos.lessonone

class Three {

    fun multiplicationTable(max: Int): Array<Array<Int>> {
        // maak arrays in arrays aan
        val table = Array(max) { Array(max) { 0 } }

        // de unit test geeft meer context aan hoe dit werkt
        for (i in 0..<max) {
            for (j in 0..<max) {
                table[i][j] = (i+1) * (j+1)
            }
        }

        return table
    }
}