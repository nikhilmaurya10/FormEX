package com.example.formex.data

class FormRepository {

    fun getFormData() : Form? {
        return BaseQuestionnaireModel.gsonParser?.fromJson<Form>(formJsonString, Form::class.java)
    }

}