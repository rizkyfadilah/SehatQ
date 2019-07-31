package com.rizkyfadilah.sehatq.di.builder

import androidx.lifecycle.ViewModelProvider
import com.rizkyfadilah.sehatq.ui.common.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module(includes = [
    (RepositoryBuilder::class),
    (AppViewModelBuilder::class)
])
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}