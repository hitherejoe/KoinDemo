package co.joebirch.koindemo.data

class DataRepositoryFactory constructor(
        private val localDataSource: DataRepository,
        private val remoteDataSource: DataRepository) {

    fun retrieveRemoteSource(): DataRepository {
        return remoteDataSource
    }

    fun retrieveLocalSource(): DataRepository {
        return localDataSource
    }

}