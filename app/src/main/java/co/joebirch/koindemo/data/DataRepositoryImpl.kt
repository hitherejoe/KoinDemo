package co.joebirch.koindemo.data

import co.joebirch.koindemo.model.Currency
import com.google.gson.Gson

open class DataRepositoryImpl(private val gson: Gson) {

    fun getCurrencies(jsonString: String): List<Currency> {
        return gson.fromJson(jsonString, Array<Currency>::class.java).toList()
    }

}