package com.afdhal_fa.unittestsample.movie

import android.app.Activity
import android.app.Application
import androidx.lifecycle.LifecycleObserver
import com.afdhal_fa.unittestsample.movie.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class SampleApplication : Application(), HasActivityInjector, LifecycleObserver {
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        initAppDependencyInjection()
    }

    private fun initAppDependencyInjection() {
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector() = activityInjector
}