package com.ronik.cryptotracker.crypto.domain

import com.ronik.cryptotracker.core.domain.util.NetworkError
import com.ronik.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins():Result<List<Coin>,NetworkError>
}