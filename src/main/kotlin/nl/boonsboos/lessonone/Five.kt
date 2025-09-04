package nl.boonsboos.lessonone

/**
 * De manier waarom de opdracht vraag om alles te doen is niet super efficiënt.
 * Je maakt namelijk met de StringBuilder eerst een nieuwe string aan,
 * om vervolgens in een andere StringBuilder weer nieuwe strings aan te maken.
 *
 * Je zou bijvoorbeeld met een extension method op de StringBuilder dat aan kunnen passen.
 * Onderaan in deze klasse staat dat uitgewerkt.
 */
class Five {
    // nested enum klasse zoals in het playground voorbeeld aangegeven
    enum class Side {
        LEFT,
        RIGHT
    }

    fun square(size: Int): String {
        return this.rectangle(size, size)
    }

    fun rectangle(height: Int, width: Int): String {
        val sb = StringBuilder()
        repeat(height, {
            sb.append(this.stars(width))
        })
        return sb.toString()
    }

    fun stars(amount: Int): String {
        val sb = StringBuilder()
        repeat(amount, {
            sb.append('*')
        })

        sb.append('\n')
        return sb.toString()
    }

    fun spaces(amount: Int): String {
        val sb = StringBuilder()
        repeat(amount, {
            sb.append(' ')
        })
        return sb.toString()
    }

    fun christmasTree(size: Int = 4): String {
        if (size <= 1) return this.christmasTreeOne()

        // width = 1 + 2 every time
        // max width is therefore height * 2 - 1 except for 1
        val sb = StringBuilder()
        for (i in 0..size) {
            sb.append(this.spaces(size - i))
            sb.append(this.stars((i * 2) + 1))
        }

        repeat(2, {
            sb.append(this.spaces(size - 1))
            sb.append(this.stars(3))
        })

        return sb.toString()
    }

    private fun christmasTreeOne(): String {
        val sb = StringBuilder()
        sb.append(this.spaces(1))
        sb.append(this.stars(1))
        sb.append(this.rectangle(2, 3))
        return sb.toString()
    }

    fun triangle(height: Int, side: Side): String {
        return when (side) {
            Side.LEFT -> triangleLeft(height)
            Side.RIGHT -> triangleRight(height)
        }

    }

    private fun triangleLeft(height: Int): String {
        val sb = StringBuilder()
        for(i in 1..height) {
            sb.append(this.stars(i))
        }
        return sb.toString()
    }

    private fun triangleRight(height: Int): String {
        val sb = StringBuilder()
        for(i in 1..height) {
            sb.append(this.spaces(height-i))
            sb.append(this.stars(i))
        }
        return sb.toString()
    }

    /* stars() en spaces() als StringBuilder extension methodes.

     Q: Waarom is dit efficiënter?
     A: Je blijft hier dezelfde StringBuilder gebruiken. De bestaande implementatie maakt eerst de string af
        en stopt hem vervolgens in een nieuwe StringBuilder.

    Q: Hoe is dat beter?
    A: Om twee redenen:
        - Nieuwe Strings aanmaken (en combineren) is (redelijk) langzaam omdat je meer geheugen moet toekennen
          aan die nieuwe Strings.
        - Omdat je dezelfde StringBuilder hergebruikt, zitten alle karakters dichter bij elkaar in het geheugen.
          Dat vindt de runtime (en je processor) erg fijn.
    */

    private fun StringBuilder.spaces(amount: Int) {
        repeat(amount, {
            this.append(' ') // `this` refereert hier naar StringBuilder
        })
    }

    private fun StringBuilder.stars(amount: Int) {
        repeat(amount, {
            this.append('*') // idem dito (hetzelfde)
        })
        this.append("\n") // idem dito
    }

    /*
        Je kan nu dus bijvoorbeeld op deze manier rectangle() implementeren:

        fun rectangle(height: Int, width: Int): String {
            val sb = StringBuilder()
            repeat(height, {
                sb.stars(width)
            })
            return sb.toString()
        }
     */
}