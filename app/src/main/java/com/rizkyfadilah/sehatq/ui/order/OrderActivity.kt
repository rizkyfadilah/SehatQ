package com.rizkyfadilah.sehatq.ui.order

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.rizkyfadilah.sehatq.R
import com.rizkyfadilah.sehatq.domain.model.Product
import com.rizkyfadilah.sehatq.ui.common.UnspecifiedTypeItem
import com.rizkyfadilah.sehatq.ui.common.performUpdates
import com.rizkyfadilah.sehatq.ui.order.adapter.OrderAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.toolbar_main.*
import javax.inject.Inject

/**
 * com.rizkyfadilah.sehatq.ui
 * Created by rizkyfadilah on 2019-07-31.
 */

class OrderActivity : DaggerAppCompatActivity() {

    private var orderAdapter: FastItemAdapter<UnspecifiedTypeItem> = FastItemAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: OrderViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(OrderViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_order)
        val toolbar: Toolbar by lazy { toolbar_main_activity }
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        initView()
    }

    private fun initView() {

        toolbar_title.text = "Order"

        rvOrder.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvOrder.adapter = orderAdapter


        viewModel.productList.observe(this, Observer {
            prepareData(it)
        })

    }

    private fun prepareData(it: List<Product>) {
        val prodItems: MutableList<OrderAdapter> = mutableListOf()
        prodItems.addAll(it.map {
            OrderAdapter(it)
        })
        orderAdapter.performUpdates(prodItems)

    }

}