package com.example.formex.ui.viewholders

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.formex.R
import com.example.formex.data.CheckBoxQuestionnaire

class CheckBoxViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val container: LinearLayout = itemView.findViewById(R.id.root)
    private val title: TextView = itemView.findViewById(R.id.title)
    fun bind(data: CheckBoxQuestionnaire) {
        title.text = data.title
        data.choices.forEach {
            val v = LayoutInflater.from(itemView.context).inflate(R.layout.layout_checkbox_items, container, false) as CheckBox
            v.tag = it.id
            v.text = it.title
            v.setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked){
                    Log.d("D>>>>>>>","Slected Choice id ${v.tag}")
                } else  {

                    Log.d("D>>>>>>>","Deseleceted Choice id ${v.tag}")
                }
            }
            container.addView(v)
        }
    }

    companion object {
        fun create(parent: ViewGroup) = CheckBoxViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_checkbox, parent, false))
    }
}