package com.kerimbr.kotlinsuperleague.data.remote.data_source
import com.kerimbr.kotlinsuperleague.core.DEFAULT_ERROR
import com.kerimbr.kotlinsuperleague.core.NETWORK_ERROR
import com.kerimbr.kotlinsuperleague.data.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

abstract class BaseDataSource {

    /**
     * This function is used to handle the response from the API
     * @param call is the API call
     * @return Flow<Resource<T>> is the response from the API
     */
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Flow<Resource<T & Any>> {
        return flow {
            emit(Resource.Loading())
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    emit(Resource.Success(body))
                } else {
                    emit(Resource.Error(NETWORK_ERROR))
                }
            } else {
                emit(Resource.Error(NETWORK_ERROR))
            }
        }.catch { e ->
            e.printStackTrace()
            emit(Resource.Error(DEFAULT_ERROR))
        }.flowOn(Dispatchers.IO)
    }

}