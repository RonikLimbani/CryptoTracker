package com.ronik.cryptotracker.core.data.networking

import com.ronik.cryptotracker.core.domain.util.NetworkError
import com.ronik.cryptotracker.core.domain.util.Result
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlin.coroutines.coroutineContext
import kotlinx.serialization.SerializationException

suspend inline fun<reified T> safeCall(
    execute: ()-> HttpResponse,
    ) : Result<T,NetworkError> {
    val response = try {
        execute()
    }catch (e : UnresolvedAddressException){
        return Result.Error(NetworkError.NO_INTERNET)
    }
    catch (e : SerializationException){
        return Result.Error(NetworkError.SERIALIZATION)
    }
    catch (e: Exception) {
        coroutineContext.ensureActive()
        return Result.Error(NetworkError.UNKNOWN)
    }
    return responseToResult(response)

}
