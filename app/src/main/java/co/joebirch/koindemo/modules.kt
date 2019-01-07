package co.joebirch.koindemo

import co.joebirch.koindemo.data.DataRepository
import co.joebirch.koindemo.data.LocalDataRepository
import co.joebirch.koindemo.presentation.CurrenciesViewModel
import com.google.gson.Gson
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val applicationModule = module {
    single { Gson() }
    single { UrlHelper(getProperty("currency_base_url")) }

    factory<DataRepository> { LocalDataRepository(get()) }
}

val browseModule = module("browse") {
    factory { CurrenciesAdapter() }
    viewModel { (jsonString: String) -> CurrenciesViewModel(get(), jsonString) }
}