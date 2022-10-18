package com.example.demo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope

import com.example.demo.model.BaseViewModel
import com.example.demo.model.ProjectViewModel
import com.example.demo.util.Constants
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mViewModel: ProjectViewModel by viewModel()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel?.apply {
            val int = 1212
            lifecycleScope.launch {
                mViewModel.loadProjectContentById(int).collectLatest { data ->
                   projectAdapter.submitData(data)
                }
            }
        }

    }
}