package com.rizkyfadilah.sehatq.di.builder

import androidx.lifecycle.ViewModel
import com.rizkyfadilah.sehatq.di.qualifier.ViewModelKey
import com.rizkyfadilah.sehatq.ui.detail.DetailViewModel
import com.rizkyfadilah.sehatq.ui.home.HomeViewModel
import com.rizkyfadilah.sehatq.ui.order.OrderViewModel
import com.rizkyfadilah.sehatq.ui.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(detailViewModel: DetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OrderViewModel::class)
    abstract fun bindOrderViewModel(orderViewModel: OrderViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel


}