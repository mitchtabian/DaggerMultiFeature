package com.codingwithmitch.daggermultifeature.app.di

import com.codingwithmitch.daggermultifeature.feature1.di.Feature1Component
import com.codingwithmitch.daggermultifeature.feature2.di.Feature2Component
import dagger.Module

@Module(subcomponents = [
    Feature1Component::class,
    Feature2Component::class
])
class SubcomponentsModule {}