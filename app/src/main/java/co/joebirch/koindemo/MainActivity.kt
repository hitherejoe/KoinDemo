package co.joebirch.koindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import co.joebirch.koindemo.data.DataRepositoryImpl
import kotlinx.android.synthetic.main.activity_main.recycler_currencies
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val currenciesAdapter: CurrenciesAdapter by inject()
    val dataRepository: DataRepositoryImpl by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupCurrenciesRecycler()

        val currenciesJson = resources.openRawResource(R.raw.currencies)
                .bufferedReader().use { it.readText() }
        val items = dataRepository.getCurrencies(currenciesJson)
        currenciesAdapter.currencies = items
    }

    private fun setupCurrenciesRecycler() {
        recycler_currencies.layoutManager = LinearLayoutManager(this)
        recycler_currencies.adapter = currenciesAdapter
    }
}