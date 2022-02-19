package com.leskov.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

abstract class BaseBindingFragment<Binding : ViewDataBinding> : Fragment() {

    private var _binding: Binding? = null
    protected val binding: Binding get() = _binding!!

    @get:LayoutRes
    protected abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    protected fun showMessage(text: String) =
        Snackbar.make(requireContext(), binding.root, text, Snackbar.LENGTH_INDEFINITE)

    protected fun showMessage(@StringRes text: Int) =
        Snackbar.make(binding.root, text, Snackbar.LENGTH_INDEFINITE)


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}