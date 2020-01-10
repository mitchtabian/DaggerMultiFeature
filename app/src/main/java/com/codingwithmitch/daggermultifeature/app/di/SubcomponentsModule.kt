package com.codingwithmitch.daggermultifeature.app.di

import com.codingwithmitch.daggermultifeature.feature1.di.Feature1Component
import com.codingwithmitch.daggermultifeature.feature2.di.Feature2Component
import com.codingwithmitch.daggermultifeature.home.di.HomeComponent
import dagger.Module

@Module(subcomponents = [
    HomeComponent::class,
    Feature1Component::class,
    Feature2Component::class
])
class SubcomponentsModule {}