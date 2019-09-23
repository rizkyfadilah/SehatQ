package com.rizkyfadilah.sehatq.ui.common

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * asia.digiasia.kaspro.common.base
 * Created by rizkyfadilah on 13/01/19.
 */

abstract class BindableListItemViewHolder<out B : ViewDataBinding>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding: B = DataBindingUtil.bind(itemView)!!
}
