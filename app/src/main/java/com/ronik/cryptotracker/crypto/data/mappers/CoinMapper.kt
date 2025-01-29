package com.ronik.cryptotracker.crypto.data.mappers

import com.ronik.cryptotracker.crypto.data.dto.CoinDto
import com.ronik.cryptotracker.crypto.domain.Coin


fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}