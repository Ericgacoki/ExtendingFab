package com.ericg.extendedfab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.ericg.extendedfab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val chatAdapter = ChatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        setUpRecyclerview()
        handleScrolls()
    }

    // can't imagine I woke up at 4 to do this! Then slept again.
    private fun setUpRecyclerview() {
        binding.recyclerView.apply {
            adapter = chatAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun handleScrolls() {
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                // scroll down with a delay of dy==20
                if ((dy-20) > 0 && binding.fab.isExtended) {
                    binding.fab.shrink()
                }
                // scroll up
                if ((dy+20) < 0 && !binding.fab.isExtended) {
                    binding.fab.extend()
                }
                //at the top
                if (!recyclerView.canScrollVertically(-1)) {
                    binding.fab.extend()
                }
            }
        })
    }
}