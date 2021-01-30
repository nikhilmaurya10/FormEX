package com.example.formex.ui.viewholders

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.example.formex.R
import com.example.formex.data.CheckBoxQuestionnaire
import com.example.formex.data.QuestionnaireResponse
import com.example.formex.helpers.FormManager

class CheckBoxViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val container: LinearLayout = itemView.findViewById(R.id.root)
    private val title: TextView = itemView.findViewById(R.id.title)
    fun bind(data: CheckBoxQuestionnaire, formManager: FormManager) {
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
                addResponse(data, formManager, container)
            }
            container.addView(v)
        }
    }

    private fun addResponse(data: CheckBoxQuestionnaire, formManager: FormManager, container: LinearLayout) {
        val listOfChoices: ArrayList<Int> = arrayListOf()
        container.children.forEach {
            if(it is CheckBox) {
                if(it.isChecked) {
                    listOfChoices.add(it.tag as Int)
                }
            }
        }
        formManager.addResponse(
            QuestionnaireResponse("checkbox",
                data.id,
                listOfChoices
            ))
    }

    companion object {
        fun create(parent: ViewGroup) = CheckBoxViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_checkbox, parent, false))
    }
}