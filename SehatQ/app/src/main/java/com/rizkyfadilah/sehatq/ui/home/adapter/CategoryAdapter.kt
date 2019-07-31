package com.rizkyfadilah.sehatq.ui.home.adapter

import android.view.View
import com.mikepenz.fastadapter.items.AbstractItem
import com.rizkyfadilah.sehatq.R
import com.rizkyfadilah.sehatq.databinding.CategoryItemRowBinding
import com.rizkyfadilah.sehatq.domain.model.Category
import com.rizkyfadilah.sehatq.ui.common.BindableListItemViewHolder

/**
 * com.rizkyfadilah.sehatq.ui.home.adapter
 * Created by rizkyfadilah on 2019-07-31.
 */

data class CategoryAdapter(
    val viewModel: Category,
    val listener: EventListener
) :
    AbstractItem<CategoryAdapter, CategoryAdapter.ViewHolder>() {

    override fun getType(): Int = hashCode()

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    override fun getLayoutRes(): Int = R.layout.category_item_row

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        holder.binding.item = viewModel
        holder.binding.executePendingBindings()
        holder.itemView.setOnClickListener { listener.onClick(viewModel) }
    }

    class ViewHolder(itemView: View) : BindableListItemViewHolder<CategoryItemRowBinding>(itemView = itemView)

    interface EventListener {
        fun onClick(itemViewModel: Category)
    }
}