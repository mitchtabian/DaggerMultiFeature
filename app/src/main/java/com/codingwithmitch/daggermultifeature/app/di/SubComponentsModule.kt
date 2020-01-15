package com.codingwithmitch.daggermultifeature.app.di

import com.codingwithmitch.daggermultifeature.feature1.di.Feature1Component
import dagger.Module

@Module(
    subcomponents = [
        Feature1Component::class
    ]
)
class SubComponentsModule