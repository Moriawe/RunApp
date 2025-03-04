package com.moriawe.run.data

import androidx.work.ListenableWorker
import com.moriawe.core.domain.util.DataError

fun DataError.toWorkerResult(): ListenableWorker.Result {
    return when(this) {
        DataError.Local.DISK_FULL -> ListenableWorker.Result.failure()
        DataError.Network.REQUEST_TIMEOUT -> ListenableWorker.Result.retry()
        DataError.Network.UNAUTHORIZED -> ListenableWorker.Result.retry()
        DataError.Network.CONFLICT -> ListenableWorker.Result.retry()
        DataError.Network.TOO_MANY_REQUESTS -> ListenableWorker.Result.retry()
        DataError.Network.NO_INTERNET_CONNECTION -> ListenableWorker.Result.retry()
        DataError.Network.PAYLOAD_TOO_LARGE -> ListenableWorker.Result.failure()
        DataError.Network.SERVER_ERROR -> ListenableWorker.Result.retry()
        DataError.Network.SERIALIZATION_ERROR -> ListenableWorker.Result.failure()
        DataError.Network.UNKNOWN_ERROR -> ListenableWorker.Result.failure()
    }
}