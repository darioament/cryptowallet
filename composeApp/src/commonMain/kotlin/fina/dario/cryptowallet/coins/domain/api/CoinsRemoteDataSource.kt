package fina.dario.cryptowallet.coins.domain.api

import fina.dario.cryptowallet.coins.data.remote.dto.CoinPriceHistoryResponseDto
import fina.dario.cryptowallet.coins.data.remote.dto.CoinsResponseDto
import fina.dario.cryptowallet.coins.data.remote.dto.CoinDetailResponseDto
import fina.dario.cryptowallet.core.domain.DataError
import fina.dario.cryptowallet.core.domain.Result


interface CoinsRemoteDataSource {
    suspend fun getListOfCoins(): Result<CoinsResponseDto, DataError.Remote>

    suspend fun getPriceHistory(coinId: String): Result<CoinPriceHistoryResponseDto, DataError.Remote>

    suspend fun  getCoinById(coinId: String): Result<CoinDetailResponseDto, DataError.Remote>

}