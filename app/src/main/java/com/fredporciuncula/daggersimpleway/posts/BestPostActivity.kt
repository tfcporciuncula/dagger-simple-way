package com.fredporciuncula.daggersimpleway.posts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fredporciuncula.daggersimpleway.R
import com.fredporciuncula.daggersimpleway.di.injector
import kotlinx.android.synthetic.main.post_activity.*

class BestPostActivity : AppCompatActivity() {

    private val viewModel by lazy {
        val viewModelFactory = injector.with(BestPostModule(myIntFromView = 10)).bestPostViewModelFactory()
        ViewModelProviders.of(this, viewModelFactory).get(BestPostViewModel::class.java)
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
