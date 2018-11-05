package co.joebirch.koindemo

import java.util.concurrent.ThreadLocalRandom

object DataFactory {

    fun randomUuid(): String {
        return java.util.UUID.randomUUID().toString()
    }

    fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }
}