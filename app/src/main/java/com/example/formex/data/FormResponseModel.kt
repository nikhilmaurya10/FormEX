package com.example.formex.data

class FormResponseModel {
    var formId: Int? = null
    var questionnaireData: ArrayList<QuestionnaireResponse> = arrayListOf()
}

class QuestionnaireResponse {
    var type: String? = null
    var id: Int? = null
    var choices: ArrayList<Int> = arrayListOf()
    var textResponse: String? = null
}