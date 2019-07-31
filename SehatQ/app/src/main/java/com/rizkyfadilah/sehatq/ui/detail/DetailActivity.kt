package com.rizkyfadilah.sehatq.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.rizkyfadilah.sehatq.R
import com.rizkyfadilah.sehatq.domain.model.Product
import com.rizkyfadilah.sehatq.ui.common.CustomBindingAdapter.loadImage
import com.rizkyfadilah.sehatq.ui.common.CustomBindingAdapter.loadImageDrawable
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar_main.*
import javax.inject.Inject

/**
 * com.rizkyfadilah.sehatq.ui.detail
 * Created by rizkyfadilah on 2019-07-31.
 */

class DetailActivity : DaggerAppCompatActivity() {


    companion object {
        const val INTENT_PRODUCT_ID = "INTENT_PRODUCT_ID"
        const val INTENT_PRODUCT_IMAGE = "INTENT_PRODUCT_IMAGE"
        const val INTENT_PRODUCT_TITLE = "INTENT_PRODUCT_TITLE"
        const val INTENT_PRODUCT_DESC = "INTENT_PRODUCT_DESC"
        const val INTENT_PRODUCT_PRICE = "INTENT_PRODUCT_PRICE"
        const val INTENT_PRODUCT_LOVE = "INTENT_PRODUCT_LOVE"
    }

    lateinit var product: Product

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: DetailViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)
        val toolbar: Toolbar by lazy { toolbar_main_activity }
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        initView()
        initializeBundle()
    }

    private fun initView() {

        toolbar_title.text = "Detail"

        submit.setOnClickListener {
            viewModel.insert(product)
        }

        viewModel.status.observe(this, Observer {
            Toast.makeText(this, "Success BUY", Toast.LENGTH_SHORT).show()
        })

    }

    private fun initializeBundle() {
        product = Product(
            id = intent?.extras?.getInt(INTENT_PRODUCT_ID) ?: 0,
            image = intent?.extras?.getString(INTENT_PRODUCT_IMAGE) ?: "",
            title = intent?.extras?.getString(INTENT_PRODUCT_TITLE) ?: "",
            description = intent?.extras?.getString(INTENT_PRODUCT_DESC) ?: "",
            price = intent?.extras?.getString(INTENT_PRODUCT_PRICE) ?: "",
            loved = intent?.extras?.getInt(INTENT_PRODUCT_LOVE) ?: 0
        )



        loadImage(image, product.image)
        loadImageDrawable(
            love,
            if (product.loved == 1) R.drawable.ico_lovelist_solid else R.drawable.ico_lovelist_outline
        )
        desc.text = product.description
        price.text = product.price

    }
}
