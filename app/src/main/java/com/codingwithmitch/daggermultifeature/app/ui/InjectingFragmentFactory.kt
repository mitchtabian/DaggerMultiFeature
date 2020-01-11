package com.codingwithmitch.daggermultifeature.app.ui

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Provider

/**
 * Based on https://github.com/alex-townsend/FragmentFactoryDaggerSample/blob/0f89cb3b38983d5868f9aa183f02e47ca44869ef/app/src/main/java/com/atownsend/fragmentfactorysample/di/factory/InjectingFragmentFactory.kt
 */
class InjectingFragmentFactory
@Inject constructor(
    private val creators: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
) : FragmentFactory() {

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentClass = loadFragmentClass(classLoader, className)
        val creator = creators[fragmentClass]
            ?: return createFragmentAsFallback(classLoader, className)

        try {
            return creator.get()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    private fun createFragmentAsFallback(classLoader: ClassLoader, className: String): Fragment {
        Log.d(TAG, "No creator found for class: $className. Using default constructor")
        return super.instantiate(classLoader, className)
    }
}