package com.rizkyfadilah.sehatq.ui.search.adapter

import android.view.View
import com.mikepenz.fastadapter.items.AbstractItem
import com.rizkyfadilah.sehatq.R
import com.rizkyfadilah.sehatq.databinding.OrderItemRowBinding
import com.rizkyfadilah.sehatq.databinding.SearchItemRowBinding
import com.rizkyfadilah.sehatq.domain.model.Product
import com.rizkyfadilah.sehatq.ui.common.BindableListItemViewHolder
import com.rizkyfadilah.sehatq.ui.home.adapter.ProductAdapter

/**
 * com.rizkyfadilah.sehatq.ui.home.adapter
 * Created by rizkyfadilah on 2019-07-31.
 */

data class SearchAdapter(
    val viewModel: Product,
    val listener: ProductAdapter.EventListener
) :
    AbstractItem<SearchAdapter, SearchAdapter.ViewHolder>() {

    override fun getType(): Int = hashCode()

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    override fun getLayoutRes(): Int = R.layout.search_item_row

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        holder.binding.item = viewModel
        holder.binding.executePendingBindings()
        holder.itemView.setOnClickListener{
            listener.onClick(viewModel)
        }
    }

    class ViewHolder(itemView: View) : BindableListItemViewHolder<SearchItemRowBinding>(itemView = itemView)

    interface EventListener {
        fun onClick(itemViewModel: Product)
    }
}