/**
 * @author YourName
 */

package com.ronik.cryptotracker.crypto.data.networking

import com.ronik.cryptotracker.core.data.networking.constructUrl
import com.ronik.cryptotracker.core.data.networking.safeCall
import com.ronik.cryptotracker.core.domain.util.NetworkError
import com.ronik.cryptotracker.core.domain.util.Result
import com.ronik.cryptotracker.core.domain.util.map
import com.ronik.cryptotracker.crypto.data.dto.CoinsResponseDto
import com.ronik.cryptotracker.crypto.data.mappers.toCoin
import com.ronik.cryptotracker.crypto.domain.Coin
import com.ronik.cryptotracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response->
            response.data.map { it.toCoin() }
        }
    }
}