package com.leskov.presentation.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseBindingActivity<Binding: ViewDataBinding> : AppCompatActivity() {

    @get:LayoutRes
    protected abstract val layoutId: Int

    private var _binding: Binding? = null
    protected val binding: Binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layoutId)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}