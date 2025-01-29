package com.ronik.cryptotracker.crypto.presentation.coin_list

import com.ronik.cryptotracker.core.domain.util.NetworkError
import java.lang.Error

sealed interface CoinListEvent {
    data class Error(val error: NetworkError) : CoinListEvent
}