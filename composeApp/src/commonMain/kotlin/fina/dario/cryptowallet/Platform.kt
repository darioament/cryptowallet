package fina.dario.cryptowallet

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform