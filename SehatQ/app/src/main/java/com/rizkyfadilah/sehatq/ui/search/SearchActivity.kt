package com.rizkyfadilah.sehatq.ui.search

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.rizkyfadilah.sehatq.R
import com.rizkyfadilah.sehatq.domain.model.Product
import com.rizkyfadilah.sehatq.ui.common.UnspecifiedTypeItem
import com.rizkyfadilah.sehatq.ui.common.performUpdates
import com.rizkyfadilah.sehatq.ui.detail.DetailActivity
import com.rizkyfadilah.sehatq.ui.home.adapter.ProductAdapter
import com.rizkyfadilah.sehatq.ui.search.adapter.SearchAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.toolbar_main.toolbar_main_activity
import kotlinx.android.synthetic.main.toolbar_search.*
import javax.inject.Inject

/**
 * com.rizkyfadilah.sehatq.ui.search
 * Created by rizkyfadilah on 2019-07-31.
 */
class SearchActivity : DaggerAppCompatActivity() {

    private var searchAdapter: FastItemAdapter<UnspecifiedTypeItem> = FastItemAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SearchViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_search)
        val toolbar: Toolbar by lazy { toolbar_main_activity }
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        initView()
    }

    private fun initView() {
        rvSearch.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvSearch.adapter = searchAdapter


        viewModel.productList.observe(this, Observer {
            prepareData(it)
        })

        search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.search(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }

    private fun prepareData(it: List<Product>) {
        val prodItems: MutableList<SearchAdapter> = mutableListOf()
        prodItems.addAll(it.map {
            SearchAdapter(it, object : ProductAdapter.EventListener {
                override fun onClick(itemViewModel: Product) {
                    val intent = Intent(this@SearchActivity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.INTENT_PRODUCT_ID, itemViewModel.id)
                    intent.putExtra(DetailActivity.INTENT_PRODUCT_TITLE, itemViewModel.title)
                    intent.putExtra(DetailActivity.INTENT_PRODUCT_DESC, itemViewModel.description)
                    intent.putExtra(DetailActivity.INTENT_PRODUCT_IMAGE, itemViewModel.image)
                    intent.putExtra(DetailActivity.INTENT_PRODUCT_PRICE, itemViewModel.price)
                    intent.putExtra(DetailActivity.INTENT_PRODUCT_LOVE, itemViewModel.loved)
                    startActivity(intent)
                }

            })
        })
        searchAdapter.performUpdates(prodItems)

    }

}