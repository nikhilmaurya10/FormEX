package com.example.formex.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.formex.data.Choice


class FormArrayAdapter(
    context: Context, textViewResourceId: Int,
    values: Array<Choice>
) : ArrayAdapter<Choice>(
    context,
    textViewResourceId,
    values
) {

    // Your custom values for the spinner (User)
    private val values: Array<Choice> = values
    override fun getCount(): Int {
        return values.size
    }

    override fun getItem(position: Int): Choice {
        return values[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val label = super.getView(position, convertView, parent) as TextView
        label.setTextColor(Color.BLACK)
        label.text = values[position].title
        return label
    }

    override fun getDropDownView(
        position: Int, convertView: View?,
        parent: ViewGroup?
    ): View {
        val label = super.getDropDownView(position, convertView, parent) as TextView
        label.setTextColor(Color.BLACK)
        label.text = values[position].title
        return label
    }

}