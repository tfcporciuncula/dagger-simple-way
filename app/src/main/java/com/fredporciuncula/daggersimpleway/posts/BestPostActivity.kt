package com.fredporciuncula.daggersimpleway.posts

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fredporciuncula.daggersimpleway.R
import com.fredporciuncula.daggersimpleway.di.injector
import kotlinx.android.synthetic.main.post_activity.*

class BestPostActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, injector.bestPostViewModelFactory()).get(BestPostViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.post_activity)

        if (savedInstanceState == null) viewModel.loadPosts()

        viewModel.bestPost().observe(this, Observer { result ->
            result?.let { bestPost.text = it.body }
        })
    }
}
