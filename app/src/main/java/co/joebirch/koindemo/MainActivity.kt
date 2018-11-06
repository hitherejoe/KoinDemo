package co.joebirch.koindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.recycler_currencies
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val currenciesAdapter: CurrenciesAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupCurrenciesRecycler()
    }

    private fun setupCurrenciesRecycler() {
        recycler_currencies.layoutManager = LinearLayoutManager(this)
        recycler_currencies.adapter = currenciesAdapter
    }
}