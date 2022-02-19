package com.leskov.movieapp

import com.leskov.movieapp.databinding.ActivityMainBinding
import com.leskov.presentation.activity.BaseBindingActivity

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_main
}