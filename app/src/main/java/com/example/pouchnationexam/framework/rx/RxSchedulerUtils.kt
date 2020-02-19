package com.example.pouchnationexam.framework.rx

import io.reactivex.CompletableTransformer
import io.reactivex.FlowableTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer

/**
 * Transformer for any RxJava stream so it subscribes to a separate thread and is
 * observed on the android UI thread.
 */
interface RxSchedulerUtils {

    fun forCompletable(): CompletableTransformer

    fun <T> forFlowable(): FlowableTransformer<T, T>

    fun <T> forObservable(): ObservableTransformer<T, T>

    fun <T> forSingle(): SingleTransformer<T, T>

}
