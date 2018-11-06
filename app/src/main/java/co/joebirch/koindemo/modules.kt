package co.joebirch.koindemo

import co.joebirch.koindemo.data.DataRepository
import co.joebirch.koindemo.data.DataRepositoryFactory
import co.joebirch.koindemo.data.LocalDataRepository
import co.joebirch.koindemo.data.RemoteDataRepository
import com.google.gson.Gson
import org.koin.dsl.module.module

val applicationModule = module {
    single { Gson() }
    factory { CurrenciesAdapter() }
    factory<DataRepository>("local") { LocalDataRepository(get()) }
    factory<DataRepository>("remote") { RemoteDataRepository() }
    factory { DataRepositoryFactory(get("local"), get("remote")) }
}