package fina.dario.cryptowallet.coins.data.remote.dto

import kotlinx.serialization.Serializable


@Serializable
data class CoinDetailResponseDto(
    val data: CoinsResponseDto
)

@Serializable
data class CoinResponseDto(
    val coin: CoinItemDto
)
