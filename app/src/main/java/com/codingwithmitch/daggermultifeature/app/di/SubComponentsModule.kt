package com.codingwithmitch.daggermultifeature.app.di

import com.codingwithmitch.daggermultifeature.feature1.di.Feature1Component
import com.codingwithmitch.daggermultifeature.main.di.MainComponent
import dagger.Module

@Module(
    subcomponents = [
        Feature1Component::class,
        MainComponent::class
    ]
)
class SubComponentsModule