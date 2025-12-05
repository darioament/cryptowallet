package fina.dario.cryptowallet.core.domain

sealed interface Result<out D, out E: Error>{
    data class Success<out D>(val data: D): Result<D, Nothing>
    data class Error<out E: fina.dario.cryptowallet.core.domain.Error>(val error: E):
            Result<Nothing, E>
}

// inline reduces calling and optimize number of calls
inline fun <T, E: Error, R> Result<T, E>.map(map: (T) -> R): Result<R, E> {
    return when(this) {
        is Result.Error -> Result.Error(error)
        is Result.Success -> Result.Success(map(data))
    }
}

// uses for like when we need to call dataBase and no item need to be returned
fun <T, E: Error> Result<T, E>.asEmptyDataResult(): EmptyResult<E> {
    return map {  }
}

// let us  execute fun if its successful, cheerful then we provide lambda with data
inline fun <T, E: Error> Result<T, E>.onSuccess(action: (T) -> Unit): Result<T, E> {
    return when(this) {
        is Result.Error -> this
        is Result.Success -> {
            action(data)
            this
        }
    }
}

// when results is a error this functions executes error value lambda while leaving successful data untouched
inline fun <T, E: Error> Result<T, E>.onError(action: (E) -> Unit): Result<T, E> {
    return when(this) {
        is Result.Error -> {
            action(error)
            this
        }
        is Result.Success -> this
    }
}

typealias EmptyResult<E> = Result<Unit, E>
