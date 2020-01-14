package com.codingwithmitch.daggermultifeature.app

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.codingwithmitch.daggermultifeature.app.di.AppComponent
import com.codingwithmitch.daggermultifeature.app.di.DaggerAppComponent
import com.codingwithmitch.daggermultifeature.app.ui.InjectingNavHostFragment

class BaseApplication : Application() {

    private val TAG: String = "AppDebug"

    private val appComponent = DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)

        this.registerActivityLifecycleCallbacks(object: ActivityLifecycleCallbacks{
            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityDestroyed(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                if(activity is FragmentActivity){
                    activity.supportFragmentManager
                        .registerFragmentLifecycleCallbacks(object: FragmentManager.FragmentLifecycleCallbacks(){

                            override fun onFragmentAttached(
                                fm: FragmentManager,
                                f: Fragment,
                                context: Context
                            ) {
                                when(f){

                                    is InjectingNavHostFragment -> {
                                        this@BaseApplication
                                            .getAppComponent()
                                            .inject(f)

                                        this@BaseApplication
                                            .getAppComponent()
                                            .feature1Component
                                            .create()
                                            .inject(f)

                                        this@BaseApplication
                                            .getAppComponent()
                                            .feature2Component
                                            .create()
                                            .inject(f)
                                    }

                                }
                                super.onFragmentAttached(fm, f, context)
                            }

                        }, true)
                }
            }

            override fun onActivityResumed(activity: Activity) {
            }

        })
    }

    fun getAppComponent(): AppComponent{
        return appComponent
    }
}