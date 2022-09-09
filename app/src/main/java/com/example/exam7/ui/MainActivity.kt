package com.example.exam7.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exam7.common.resource.Resource
import com.example.exam7.databinding.ActivityMainBinding
import com.example.exam7.ui.source.HorizontalAdapter
import com.example.exam7.ui.source.VerticalAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val verticalAdapter = VerticalAdapter()
    private val horizontalAdapter = HorizontalAdapter()

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initVertical()
        initHorizontal()
        observeVertical()
        observeHorizontal()
    }

    private fun initVertical() {
        binding.rvVertical.apply {
            adapter = verticalAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun initHorizontal() {
        binding.rvHorizontal.apply {
         adapter = horizontalAdapter
         layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun observeVertical() {
        lifecycleScope.launch {
            viewModel.getVerticalItems().collectLatest {
                verticalAdapter.currentList
            }
        }
    }

    private fun observeHorizontal() {
        lifecycleScope.launch {
            viewModel.getHorizontalItems().collectLatest {
                verticalAdapter.currentList
            }
        }
    }
}
