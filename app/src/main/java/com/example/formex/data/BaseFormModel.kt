package com.example.formex.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.formex.helpers.RuntimeTypeAdapterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder

open class BaseQuestionnaireModel {
    var id: Int? = null
    var title: String? = null
    var type: String? = null

    companion object {
        private val adapterFactory = RuntimeTypeAdapterFactory.of(BaseQuestionnaireModel::class.java, "type", true)
        var gsonParser: Gson? = null

        init {
            adapterFactory.registerSubtype(TextBoxQuestionnaire::class.java, "textbox")
            adapterFactory.registerSubtype(CheckBoxQuestionnaire::class.java, "checkbox")
            adapterFactory.registerSubtype(RadioBtnQuestionnaire::class.java, "radiobtn")
            adapterFactory.registerSubtype(DropDownQuestionnaire::class.java, "dropdown")
            gsonParser = GsonBuilder().registerTypeAdapterFactory(adapterFactory).create()
        }
    }
}
class TextBoxQuestionnaire : BaseQuestionnaireModel() {
    val maxAllowedCharacters = 100
}
class CheckBoxQuestionnaire : BaseQuestionnaireModel() {
    val maxChoice = 4
    val choices: ArrayList<Choice> = arrayListOf()

}

class RadioBtnQuestionnaire : BaseQuestionnaireModel() {
    val choices: ArrayList<Choice> = arrayListOf()
}

class DropDownQuestionnaire : BaseQuestionnaireModel() {
    val choices: ArrayList<Choice> = arrayListOf()
    val moreChoiceEndpoint: String? = null
    var choicesLiveData: LiveData<ExtraChoiceResult>? = null
}

class Form(
    val formId: Int,
    val formTitle: String,
    val formQuestionnaire: ArrayList<BaseQuestionnaireModel>
)
class Choice(val id: Int, val title: String)