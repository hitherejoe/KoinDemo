package co.joebirch.koindemo.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import co.joebirch.koindemo.data.DataRepositoryFactory
import co.joebirch.koindemo.model.Currency

class CurrenciesViewModel constructor(
        private val dataRepositoryFactory: DataRepositoryFactory,
        private val jsonString: String): ViewModel() {

    private val currencyLiveData = MutableLiveData<List<Currency>>()

    fun observeCurrencies(): LiveData<List<Currency>> {
        return currencyLiveData
    }

    fun retrieveCurrencies() {
        val data = dataRepositoryFactory.retrieveLocalSource().getCurrencies(jsonString)
        currencyLiveData.postValue(data)
    }

}