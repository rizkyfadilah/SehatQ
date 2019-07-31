package com.rizkyfadilah.sehatq.di.builder

import com.rizkyfadilah.sehatq.ui.detail.DetailActivity
import com.rizkyfadilah.sehatq.ui.home.MainActivity
import com.rizkyfadilah.sehatq.ui.login.LoginActivity
import com.rizkyfadilah.sehatq.ui.order.OrderActivity
import com.rizkyfadilah.sehatq.ui.search.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityProviders::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [DetailActivityProviders::class])
    abstract fun bindDetailActivity(): DetailActivity

    @ContributesAndroidInjector(modules = [OrderActivityProviders::class])
    abstract fun bindOrderActivity(): OrderActivity

    @ContributesAndroidInjector(modules = [SearchActivityProviders::class])
    abstract fun bindSearchActivity(): SearchActivity

    @ContributesAndroidInjector(modules = [LoginActivityProviders::class])
    abstract fun bindLoginActivity(): LoginActivity

}