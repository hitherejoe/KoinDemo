package co.joebirch.koindemo.data

import co.joebirch.koindemo.model.Currency
import com.google.gson.Gson

open class LocalDataRepository(private val gson: Gson): DataRepository {

    override fun getCurrencies(jsonString: String): List<Currency> {
        return gson.fromJson(jsonString, Array<Currency>::class.java).toList()
    }

}