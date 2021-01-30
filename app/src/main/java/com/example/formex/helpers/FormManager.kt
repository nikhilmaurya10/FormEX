package com.example.formex.helpers

import com.example.formex.data.FormResponseModel
import com.example.formex.data.QuestionnaireResponse

class FormManager(private val formId: Int) {
    var formDataResponse: FormResponseModel = FormResponseModel()

    init {
        formDataResponse.formId = formId
    }
    fun addResponse(formQuestionnaireResponse: QuestionnaireResponse) {
        val data = formDataResponse.questionnaireData.find { it.id == formQuestionnaireResponse.id }
        if (data == null) {
            formDataResponse.questionnaireData.add(formQuestionnaireResponse)
        } else {
            formDataResponse.questionnaireData.remove(data)
            formDataResponse.questionnaireData.add(formQuestionnaireResponse)
        }
    }
}