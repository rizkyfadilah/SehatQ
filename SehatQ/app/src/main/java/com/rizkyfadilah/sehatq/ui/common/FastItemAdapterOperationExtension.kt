package com.rizkyfadilah.sehatq.ui.common

import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.mikepenz.fastadapter.commons.utils.FastAdapterDiffUtil

/**
 * asia.digiasia.kaspro.common.extension
 * Created by rizkyfadilah on 13/01/19.
 */

typealias UnspecifiedTypeItem = IItem<*, *>

operator fun <Item : UnspecifiedTypeItem> FastItemAdapter<Item>.plusAssign(item: Item) {
    add(item)
    notifyAdapterDataSetChanged()
}

operator fun <Item : UnspecifiedTypeItem> FastItemAdapter<Item>.plusAssign(items: List<Item>) {
    items.forEach { add(it) }
    notifyAdapterDataSetChanged()
}

fun <Item : UnspecifiedTypeItem> FastItemAdapter<Item>.performUpdates(newItems: List<Item>) {
    val diffResult = FastAdapterDiffUtil.calculateDiff(this, newItems, DiffableCallback())
    FastAdapterDiffUtil.set(this, diffResult)
}
