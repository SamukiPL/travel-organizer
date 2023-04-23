package me.samuki.travel.common.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

typealias ListResult<T> = Result<List<T>>

inline fun <T> Flow<Result<T>>.onEachResultSuccess(crossinline onSuccess: (T) -> Unit) = onEach { result ->
    result.onSuccess(onSuccess)
}

inline fun <T> Flow<Result<T>>.onEachResultFailure(crossinline onFailure: (Throwable) -> Unit) = onEach { result ->
    result.onFailure(onFailure)
}
