package com.codingwithmitch.daggermultifeature.feature1.di.keys

import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class Feature1FragmentKey(val value: KClass<out Fragment>)
