package com.example.formex.ui.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.formex.R
import com.example.formex.data.DropDownQuestionnaire
import com.example.formex.data.ExtraChoiceResult
import com.example.formex.data.QuestionnaireResponse
import com.example.formex.helpers.FormManager
import com.example.formex.ui.adapter.FormArrayAdapter


class DropDownViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.title)
    private val spinner: Spinner = itemView.findViewById(R.id.spinner)
    fun bind(data: DropDownQuestionnaire, formManager: FormManager, lifecycleOwner: LifecycleOwner) {
        title.text  = data.title
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                formManager.addResponse(
                    QuestionnaireResponse("dropdown",
                        data.id,
                        arrayListOf(id.toInt()),
                        null
                    )
                )
            }

        }

        var aa = FormArrayAdapter(itemView.context, android.R.layout.simple_spinner_item, arrayOf())
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = aa
        data.choicesLiveData?.observe(lifecycleOwner, Observer {
            when (it) {
                is ExtraChoiceResult.Success -> {
                    val al = FormArrayAdapter(itemView.context, android.R.layout.simple_spinner_item, it.data.toTypedArray())
                    spinner.adapter = al
                }
            }
        })
    }

    companion object {
        fun create(parent: ViewGroup) = DropDownViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_dropown, parent, false
            )
        )
    }
}