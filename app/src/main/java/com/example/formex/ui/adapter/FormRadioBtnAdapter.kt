package com.example.formex.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.formex.data.FormResponseModel
import com.example.formex.data.RadioBtnQuestionnaire
import com.example.formex.helpers.FormManager
import com.example.formex.ui.viewholders.RadioBtnViewHolder

class FormRadioBtnAdapter(
    val data: RadioBtnQuestionnaire,
    private val formManager: FormManager
): RecyclerView.Adapter<RadioBtnViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioBtnViewHolder {
        return RadioBtnViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: RadioBtnViewHolder, position: Int) {
        holder.bind(data, formManager)
    }
}