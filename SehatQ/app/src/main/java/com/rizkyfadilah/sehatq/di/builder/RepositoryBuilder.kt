package com.rizkyfadilah.sehatq.di.builder

import com.rizkyfadilah.sehatq.data.repository.AppRepoImp
import com.rizkyfadilah.sehatq.domain.repository.AppRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBuilder {
    @Binds
    abstract fun bindsRepository(repoImp: AppRepoImp): AppRepository
}