package com.example.formex.ui.viewholders

import android.content.Context
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.example.formex.R
import com.example.formex.data.TextBoxQuestionnaire


class TextBoxViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val editText: EditText = itemView.findViewById(R.id.textBox)
    private val title: TextView = itemView.findViewById(R.id.title)
    fun bind(data: TextBoxQuestionnaire) {
        title.text = data.title
        editText.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //saveData()
                val imm = v.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(v.windowToken, 0)
                v.clearFocus()
                Toast.makeText(itemView.context, editText.text, Toast.LENGTH_LONG).show()
                true
            } else {
                false
            }
        }
    }
    companion object {
        fun create(parent: ViewGroup) = TextBoxViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_textbox, parent, false))
    }
}