package com.rizkyfadilah.sehatq.ui.order.adapter

import android.view.View
import com.mikepenz.fastadapter.items.AbstractItem
import com.rizkyfadilah.sehatq.R
import com.rizkyfadilah.sehatq.databinding.OrderItemRowBinding
import com.rizkyfadilah.sehatq.domain.model.Product
import com.rizkyfadilah.sehatq.ui.common.BindableListItemViewHolder

/**
 * com.rizkyfadilah.sehatq.ui.home.adapter
 * Created by rizkyfadilah on 2019-07-31.
 */

data class OrderAdapter(
    val viewModel: Product
) :
    AbstractItem<OrderAdapter, OrderAdapter.ViewHolder>() {

    override fun getType(): Int = hashCode()

    override fun getViewHolder(v: View): ViewHolder =
        ViewHolder(v)

    override fun getLayoutRes(): Int = R.layout.order_item_row

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        holder.binding.item = viewModel
        holder.binding.executePendingBindings()
    }

    class ViewHolder(itemView: View) : BindableListItemViewHolder<OrderItemRowBinding>(itemView = itemView)

}