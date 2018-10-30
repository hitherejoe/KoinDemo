package co.joebirch.koindemo

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import co.joebirch.koindemo.presentation.CurrenciesViewModel
import kotlinx.android.synthetic.main.activity_main.recycler_currencies
import org.koin.android.ext.android.inject
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    val currenciesAdapter: CurrenciesAdapter by inject()
    val currenciesViewModel: CurrenciesViewModel by viewModel {
        val currenciesJson = resources.openRawResource(R.raw.currencies)
                .bufferedReader().use { it.readText() }
        parametersOf(currenciesJson)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindScope(getOrCreateScope("browse"))

        setupCurrenciesRecycler()

        currenciesViewModel.observeCurrencies().observe(this, Observer {
            it?.let { currenciesAdapter.currencies = it }
        })

        currenciesViewModel.retrieveCurrencies()
    }

    private fun setupCurrenciesRecycler() {
        recycler_currencies.layoutManager = LinearLayoutManager(this)
        recycler_currencies.adapter = currenciesAdapter
    }
}