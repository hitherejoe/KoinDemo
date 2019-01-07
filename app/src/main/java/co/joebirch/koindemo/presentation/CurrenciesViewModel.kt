package co.joebirch.koindemo.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import co.joebirch.koindemo.data.DataRepository
import co.joebirch.koindemo.model.Currency

class CurrenciesViewModel constructor(
        private val dataRepository: DataRepository,
        private val jsonString: String): ViewModel() {

    private val currencyLiveData = MutableLiveData<List<Currency>>()

    fun observeCurrencies(): LiveData<List<Currency>> {
        return currencyLiveData
    }

    fun retrieveCurrencies() {
        val data = dataRepository.getCurrencies(jsonString)
        currencyLiveData.postValue(data)
    }

}