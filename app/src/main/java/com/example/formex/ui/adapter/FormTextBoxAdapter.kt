package com.example.formex.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.formex.data.FormResponseModel
import com.example.formex.data.TextBoxQuestionnaire
import com.example.formex.helpers.FormManager
import com.example.formex.ui.viewholders.TextBoxViewHolder

class FormTextBoxAdapter(val data: TextBoxQuestionnaire, private val formManager: FormManager): RecyclerView.Adapter<TextBoxViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextBoxViewHolder {
        return TextBoxViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: TextBoxViewHolder, position: Int) {
        holder.bind(data, formManager)
    }

}