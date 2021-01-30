package com.example.formex.ui.viewholders

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.formex.R
import com.example.formex.data.CheckBoxQuestionnaire
import com.example.formex.data.RadioBtnQuestionnaire


class RadioBtnViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.title)
    private val radioGroup: RadioGroup = itemView.findViewById(R.id.radioGroup)
    fun bind(data: RadioBtnQuestionnaire) {
        title.text = data.title
        radioGroup.orientation = RadioGroup.VERTICAL

        data.choices.forEach {
            val rb = RadioButton(itemView.context)
            rb.text = it.title
            rb.id = it.id
            radioGroup.addView(rb)
        }
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            Log.d("D>>>>>>>", "CheckId is $checkedId")
        }

    }
    companion object {
        fun create(parent: ViewGroup) = RadioBtnViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_radio_group, parent, false))
    }
}
