package me.samuki.travel.common.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

typealias ListResult<T> = Result<List<T>>

fun <T> Flow<Result<T>>.onEachResultSuccess(onSuccess: (T) -> Unit) = onEach { result ->
    result.onSuccess(onSuccess)
}

fun <T> Flow<Result<T>>.onEachResultFailure(onFailure: (Throwable) -> Unit) = onEach { result ->
    result.onFailure(onFailure)
}
