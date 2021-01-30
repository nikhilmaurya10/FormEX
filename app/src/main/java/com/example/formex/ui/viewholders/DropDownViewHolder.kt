package com.example.formex.ui.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.formex.R
import com.example.formex.data.DropDownQuestionnaire

class DropDownViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//    private val title: TextView = itemView.findViewById(R.id.title)
    fun bind(data: DropDownQuestionnaire) {

    }

    companion object {
        fun create(parent: ViewGroup) = DropDownViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_dropown, parent, false))
    }
}