package com.leskov.presentation.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leskov.presentation.R
import com.leskov.presentation.databinding.FragmentSplashBinding
import com.leskov.presentation.fragment.BaseBindingFragment

class SplashFragment : BaseBindingFragment<FragmentSplashBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_splash

}