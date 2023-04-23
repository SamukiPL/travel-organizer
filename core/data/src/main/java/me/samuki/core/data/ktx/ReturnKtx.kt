package me.samuki.core.data.ktx

inline fun <T> returnResult(
    block: () -> T
): Result<T> {
    return try {
        Result.success(block())
    } catch (e: Throwable) {
        Result.failure(e)
    }
}
