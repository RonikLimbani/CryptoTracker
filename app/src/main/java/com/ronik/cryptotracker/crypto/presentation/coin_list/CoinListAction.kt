/**
 * @author YourName
 */

package com.ronik.cryptotracker.crypto.presentation.coin_list

import com.ronik.cryptotracker.crypto.presentation.models.CoinUi


sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi): CoinListAction
}