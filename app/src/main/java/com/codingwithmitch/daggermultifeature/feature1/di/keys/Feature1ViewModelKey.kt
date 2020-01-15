package com.codingwithmitch.daggermultifeature.feature1.di.keys

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class Feature1ViewModelKey(val value: KClass<out ViewModel>)
