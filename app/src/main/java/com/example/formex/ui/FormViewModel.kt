package com.example.formex.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.formex.data.Form
import com.example.formex.data.FormRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class FormViewModel(private val repository: FormRepository): ViewModel() {

    private val _formData: MutableLiveData<FormDataState> = MutableLiveData(FormDataState.Loading)
    val formData = _formData

    init {
        getFormData()
    }

    private fun getFormData(): LiveData<FormDataState> {
        _formData.value = FormDataState.Loading
        viewModelScope.launch {
            val data = repository.getFormData()
            if (data != null) {
                _formData.value = FormDataState.Result(data)
                return@launch
            }
            _formData.value = FormDataState.Error(Exception("Something went Wrong"))
        }
        return formData
    }
}

sealed class FormDataState {
    object Loading:FormDataState()
    class Error(t: Throwable):FormDataState()
    class Result(val data: Form):FormDataState()
}