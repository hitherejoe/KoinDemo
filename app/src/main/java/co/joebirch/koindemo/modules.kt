package co.joebirch.koindemo

import co.joebirch.koindemo.data.DataRepository
import co.joebirch.koindemo.data.DataRepositoryImpl
import com.google.gson.Gson
import org.koin.dsl.module.module

val applicationModule = module {
    single { Gson() }
    factory { CurrenciesAdapter() }
    factory<DataRepository> { DataRepositoryImpl(get()) }
}