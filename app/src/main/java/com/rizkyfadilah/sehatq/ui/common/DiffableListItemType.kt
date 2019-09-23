package com.rizkyfadilah.sehatq.ui.common

import com.mikepenz.fastadapter.diff.DiffCallback

/**
 * asia.digiasia.kaspro.common.extension
 * Created by rizkyfadilah on 13/01/19.
 */

interface DiffableListItemType {
    fun itemIdentifier(): Any
    fun comparableContents(): List<Any>
}

class DiffableCallback<Item : UnspecifiedTypeItem> : DiffCallback<Item> {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        if (oldItem is DiffableListItemType && newItem is DiffableListItemType) {
            return oldItem.itemIdentifier() == newItem.itemIdentifier()
        }
        return false
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        if (oldItem is DiffableListItemType && newItem is DiffableListItemType) {
            return oldItem.comparableContents().withIndex().none {
                it.value != newItem.comparableContents()[it.index]
            }
        }
        return false
    }

    override fun getChangePayload(
            oldItem: Item, oldItemPosition: Int,
            newItem: Item, newItemPosition: Int): Any? = null

}
