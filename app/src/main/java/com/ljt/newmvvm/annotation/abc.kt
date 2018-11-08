package com.ljt.newmvvm.annotation

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


fun main(args: Array<String>) {

    Observable.range(1, 1_000_000)
            .observeOn(Schedulers.computation())
            .subscribe(ComputeFunction::compute)

}