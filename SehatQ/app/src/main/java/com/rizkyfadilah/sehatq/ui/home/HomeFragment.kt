package com.rizkyfadilah.sehatq.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.rizkyfadilah.sehatq.R
import com.rizkyfadilah.sehatq.domain.model.Category
import com.rizkyfadilah.sehatq.domain.model.DataEntity
import com.rizkyfadilah.sehatq.domain.model.Product
import com.rizkyfadilah.sehatq.ui.common.UnspecifiedTypeItem
import com.rizkyfadilah.sehatq.ui.common.performUpdates
import com.rizkyfadilah.sehatq.ui.detail.DetailActivity
import com.rizkyfadilah.sehatq.ui.home.adapter.CategoryAdapter
import com.rizkyfadilah.sehatq.ui.home.adapter.ProductAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


class HomeFragment : DaggerFragment() {

    companion object {
        val FRAGMENT_NAME: String = HomeFragment::class.java.name
    }

    var catAdapter: FastItemAdapter<UnspecifiedTypeItem> = FastItemAdapter()

    var prodAdapter: FastItemAdapter<UnspecifiedTypeItem> = FastItemAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        with(viewModel) {

            data.observe(this@HomeFragment, Observer {
                prepareData(it)
            })

            error.observe(this@HomeFragment, Observer {
                Toast.makeText(context, "${it?.message}", Toast.LENGTH_LONG).show()
            })
        }
    }

    private fun initView() {
        rvCategory.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        rvCategory.adapter = catAdapter

        rvProduct.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvProduct.adapter = prodAdapter

    }

    private fun prepareData(it: DataEntity) {
        val catItems: MutableList<CategoryAdapter> = mutableListOf()
        catItems.addAll(it.categoryList.map {
            CategoryAdapter(it, object : CategoryAdapter.EventListener {
                override fun onClick(itemViewModel: Category) {
                }
            })
        })
        catAdapter.performUpdates(catItems)


        val prodItems: MutableList<ProductAdapter> = mutableListOf()
        prodItems.addAll(it.productList.map {
            ProductAdapter(it, object : ProductAdapter.EventListener {
                override fun onClick(itemViewModel: Product) {
                    val intent = Intent(activity, DetailActivity::class.java)
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
        prodAdapter.performUpdates(prodItems)

    }

}