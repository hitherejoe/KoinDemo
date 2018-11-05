package co.joebirch.koindemo

import co.joebirch.koindemo.model.Currency

object CurrencyFactory {

    fun makeCurrency(): Currency {
        return Currency(DataFactory.randomInt(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid())
    }

    fun makeCurrencyList(count: Int): List<Currency> {
        return (0..count).map { makeCurrency() }
    }

}