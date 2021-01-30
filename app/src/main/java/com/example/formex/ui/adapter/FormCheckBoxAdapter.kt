package com.example.formex.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.formex.data.CheckBoxQuestionnaire
import com.example.formex.data.TextBoxQuestionnaire
import com.example.formex.ui.viewholders.CheckBoxViewHolder
import com.example.formex.ui.viewholders.TextBoxViewHolder

class FormCheckBoxAdapter(val data: CheckBoxQuestionnaire): RecyclerView.Adapter<CheckBoxViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckBoxViewHolder {
        return CheckBoxViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: CheckBoxViewHolder, position: Int) {
        return holder.bind(data)
    }
}