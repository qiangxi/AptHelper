package com.rqq.apt.demo

import com.rqq.demo.TestApt
import com.rqq.demo.TestApt2

/**
 * Create By renqiangqiang . 9/4/21
 */
@TestApt(IDemo::class)
interface IDemo {

    @TestApt2
    fun <R> test1(age: Int, r: R): R?
}