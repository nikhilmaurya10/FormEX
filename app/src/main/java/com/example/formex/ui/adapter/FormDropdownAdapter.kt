package com.example.formex.ui.adapter

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.formex.data.DropDownQuestionnaire
import com.example.formex.ui.viewholders.DropDownViewHolder

class FormDropdownAdapter(val data: DropDownQuestionnaire, private val lifecycleOwner: LifecycleOwner): RecyclerView.Adapter<DropDownViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DropDownViewHolder {
        return DropDownViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: DropDownViewHolder, position: Int) {
        return holder.bind(data, lifecycleOwner)
    }
}