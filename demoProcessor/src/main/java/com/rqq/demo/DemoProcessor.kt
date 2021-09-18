package com.rqq.demo

import com.google.auto.service.AutoService
import com.rqq.github.pkgName
import java.util.*
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor::class)
class DemoProcessor : AbstractProcessor() {
    private lateinit var mMessager: Messager
    private lateinit var mEnv: ProcessingEnvironment

    @Synchronized
    override fun init(processingEnvironment: ProcessingEnvironment) {
        super.init(processingEnvironment)
        mEnv = processingEnvironment
        mMessager = processingEnvironment.messager
        log(0) {
            "init"
        }
    }

    private fun log(index: Int, action: () -> String) {
        mMessager.printMessage(Diagnostic.Kind.NOTE, "rqq==$index: ${action()}")
    }

    override fun getSupportedAnnotationTypes(): Set<String> {
        val types: MutableSet<String> = LinkedHashSet()
        types.add(TestApt::class.java.canonicalName)
        types.add(TestApt2::class.java.canonicalName)
        return types
    }

    override fun process(set: Set<TypeElement?>, roundEnvironment: RoundEnvironment): Boolean {
        val testAptElements = roundEnvironment.getElementsAnnotatedWith(TestApt::class.java)
        testAptElements.forEach { element: Element ->
            log(1) {
                "pkg: ${element}, ${element.pkgName(mEnv)}"
            }
        }
        val testApt2Elements = roundEnvironment.getElementsAnnotatedWith(TestApt2::class.java)
        testApt2Elements.forEach { element: Element ->
            log(2) {
                "pkg: ${element}, ${element.pkgName(mEnv)}"
            }
        }
        return true
    }
}