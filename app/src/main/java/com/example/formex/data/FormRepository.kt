package com.example.formex.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class FormRepository {

    fun getFormData(): Form? {
        return BaseQuestionnaireModel.gsonParser?.fromJson<Form>(formJsonString, Form::class.java)
    }

    suspend fun getExtraData(url: String): Flow<ExtraChoiceResult> {
        return flow {
            //simulating data coming from room db.
            emit(ExtraChoiceResult.Success(listOf(
                Choice(21, "a"),
                Choice(22, "b"),
                Choice(23, "c")
            )))
            delay(5000) //simulating new data coming from server after few seconds
            emit(
                ExtraChoiceResult.Success(
                    Gson().fromJson<ArrayList<Choice>>(
                        extraChoicesList,
                        object : TypeToken<List<Choice>>() {}.type
                    )
                )
            )
        }
    }

}