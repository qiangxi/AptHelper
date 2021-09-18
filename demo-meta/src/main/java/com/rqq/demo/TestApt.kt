package com.rqq.demo

import kotlin.reflect.KClass

/**
 * Create By renqiangqiang . 9/4/21
 */
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.FIELD,
    AnnotationTarget.VALUE_PARAMETER
)
@Retention(AnnotationRetention.SOURCE)
annotation class TestApt(val clazz: KClass<*>)
