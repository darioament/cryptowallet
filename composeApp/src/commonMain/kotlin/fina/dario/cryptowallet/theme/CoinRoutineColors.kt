package fina.dario.cryptowallet.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CoinRoutineColors(
    val profitGreen: Color = Color.Unspecified,
    val lossRed: Color = Color.Unspecified
)

val ProfitGreenColor = Color(color = 0xFF32DE84)
val LossRedColor = Color(color = 0xFFD2122E)

val DarkProfitGreenColor = Color(color = 0xFF32DE84)
val DarkLossRedColor = Color(color = 0xFFD2122E)


val LightCustomColorPalette = CoinRoutineColors(
    profitGreen = ProfitGreenColor,
    lossRed = LossRedColor
)
val DarkCustomColorPalette = CoinRoutineColors(
    profitGreen = ProfitGreenColor,
    lossRed = LossRedColor
)

val LocalCoinRoutineColorsPalette = compositionLocalOf { CoinRoutineColors() }