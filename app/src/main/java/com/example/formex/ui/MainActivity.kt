package com.example.formex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.formex.data.*
import com.example.formex.databinding.ActivityMainBinding
import com.example.formex.ui.adapter.FormCheckBoxAdapter
import com.example.formex.ui.adapter.FormDropdownAdapter
import com.example.formex.ui.adapter.FormRadioBtnAdapter
import com.example.formex.ui.adapter.FormTextBoxAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: FormViewModel
    var formData: Form? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = ViewModelProvider(this, ViewModelFactory(FormRepository()))
            .get(FormViewModel::class.java)
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        viewModel.formData.observe(this, Observer {
            when(it) {
                is FormDataState.Loading -> {
                    Log.d("D>>>>>>>>", "Loading")
                }
                is FormDataState.Result -> {
                    Log.d("D>>>>>>>>", it.toString())
                    formData = it.data
                    setupRecyclerView()
                }
                is FormDataState.Error -> {
                    Log.d("D>>>>>>>>", it.toString())
                }
            }
        })
    }
    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        formData?.let {
            val textQA = formData!!.formQuestionnaire.map { when(it) {
                is TextBoxQuestionnaire -> FormTextBoxAdapter(it)
                is CheckBoxQuestionnaire -> FormCheckBoxAdapter(it)
                is RadioBtnQuestionnaire -> FormRadioBtnAdapter(it)
                is DropDownQuestionnaire -> FormDropdownAdapter(it, this@MainActivity)
                else -> {}
            }}
            textQA as List<RecyclerView.Adapter<out RecyclerView.ViewHolder>>
            val adapter = ConcatAdapter(textQA)
            binding.recyclerView.adapter = adapter
        }
    }
}
