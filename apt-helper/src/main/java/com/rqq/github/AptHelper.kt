package com.rqq.github

import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.Element
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.VariableElement

/**
 * Create By renqiangqiang . 9/4/21
 */

/**
 * 获取Element所在包名
 */
fun Element.pkgName(env: ProcessingEnvironment): String {
    return env.elementUtils.getPackageOf(this).qualifiedName.toString()
}

/**
 * 获取方法名，如 `Student test(User u)`，返回：test
 */
fun ExecutableElement.methodName(): String {
    return simpleName.toString()
}

/**
 * 获取方法返回值类型，如 Student test(User u)，返回：Student的Element类型
 */
fun ExecutableElement.returnTypeElement(env: ProcessingEnvironment): Element {
    return env.typeUtils.asElement(returnType)
}

/**
 * 获取当前方法所在类
 */
fun ExecutableElement.parentClass(): Element {
    return enclosingElement
}

fun Any.safetyGetValue(action: () -> Unit) {
    try {
        action()
    } catch (e: Throwable) {
    }
}

/**
 * 获取参数类型的名称, 如 void test(User u)，true：返回com.demo.User, false：返回User
 *
 * @param qualified 是否全量类名，true：包名+类名，false：只有类名
 */
fun VariableElement.typeName(qualified: Boolean = false): String {
    val qualifiedName = toString()
    return if (qualified) qualifiedName else qualifiedName.substringAfterLast(".")
}

/**
 * 获取参数名，如 void test(User u)，返回：u
 */
fun VariableElement.paramName(): String {
    return simpleName.toString()
}

