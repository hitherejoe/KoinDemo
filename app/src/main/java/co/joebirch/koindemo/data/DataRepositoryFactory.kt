package co.joebirch.koindemo.data

open class DataRepositoryFactory(
        private val localDataSource: DataRepository,
        private val remoteDataSource: DataRepository) {

    fun retrieveRemoteSource(): DataRepository {
        return remoteDataSource
    }

    fun retrieveLocalSource(): DataRepository {
        return localDataSource
    }
}