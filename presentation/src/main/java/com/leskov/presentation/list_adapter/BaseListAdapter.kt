package com.leskov.presentation.list_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.leskov.presentation.view_holder.BindingHolder

abstract class BaseListAdapter<T, Binding : ViewDataBinding>(callback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, BindingHolder<Binding>>(callback) {

    @get:LayoutRes
    protected abstract val layoutId: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<Binding> =
        BindingHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false))

    override fun onBindViewHolder(holder: BindingHolder<Binding>, position: Int) {
        bind(holder.binding, getItem(holder.adapterPosition), holder.adapterPosition)
    }

    protected abstract fun bind(binding: Binding, item: T, position: Int)


}