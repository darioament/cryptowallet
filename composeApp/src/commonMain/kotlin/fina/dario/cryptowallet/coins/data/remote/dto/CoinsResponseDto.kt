package fina.dario.cryptowallet.coins.data.remote.dto

import kotlinx.serialization.Serializable
// we are using this for communication with api
@Serializable
data class CoinsResponseDto(
    val data: CoinsListDto
)

@Serializable
data class CoinsListDto(
    val coins: List<CoinItemDto>
)

// CoinItemDto is for storing each info of coins -> thats want we will get from json
@Serializable
data class CoinItemDto(
    val uuid: String,
    val symbol: String,
    val name: String,
    val iconUrl: String,
    val price: Double, //BigDecimal for realWorld app. It is better for precision, double is just for simplicity
    val rank: Int,
    val change: Double,
)