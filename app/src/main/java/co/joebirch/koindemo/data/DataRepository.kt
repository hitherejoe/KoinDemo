package co.joebirch.koindemo.data

import co.joebirch.koindemo.model.Currency

interface DataRepository {

    fun getCurrencies(jsonString: String): List<Currency>

}