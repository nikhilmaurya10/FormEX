package com.example.formex.ui

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.formex.data.*
import com.example.formex.helpers.FormManager
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception

class FormViewModel(private val repository: FormRepository): ViewModel() {

    private val _formData: MutableLiveData<FormDataState> = MutableLiveData(FormDataState.Loading)
    val formData = _formData
    var formManager: FormManager? = null
    init {
        getFormData()
    }

    private fun getFormData(): LiveData<FormDataState> {
        _formData.value = FormDataState.Loading
        viewModelScope.launch {
            val data = repository.getFormData()
            if (data != null) {
                data.formQuestionnaire?.map {
                    if(it is DropDownQuestionnaire && !it.moreChoiceEndpoint.isNullOrEmpty()) {
                        it.choicesLiveData = getExtraData(it.moreChoiceEndpoint)
                    }
                }
                formManager = FormManager(data.formId)
                _formData.value = FormDataState.Result(data)
                return@launch
            }
            _formData.value = FormDataState.Error(Exception("Something went Wrong"))
        }
        return formData
    }
    private fun getExtraData(url: String): LiveData<ExtraChoiceResult> {
        var ld: MutableLiveData<ExtraChoiceResult> = MutableLiveData()
        viewModelScope.launch {
            repository.getExtraData(url).collect {
                ld.value  = it
            }

        }
        return ld
    }

    fun submitResponse() {
        if(formManager != null) {
            Log.d("D>>>>>>>>", Gson().toJson(formManager))
        }
    }
}

sealed class FormDataState {
    object Loading:FormDataState()
    class Error(t: Throwable):FormDataState()
    class Result(val data: Form):FormDataState()
}