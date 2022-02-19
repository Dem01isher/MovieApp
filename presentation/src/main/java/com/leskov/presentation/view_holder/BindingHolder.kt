package com.leskov.presentation.view_holder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BindingHolder<Binding: ViewDataBinding>(val binding: Binding) : RecyclerView.ViewHolder(binding.root)