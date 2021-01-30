package com.example.formex.data

sealed class ExtraChoiceResult {
    data class Success(val data: List<Choice>) : ExtraChoiceResult()
    data class Error(val error: Exception) : ExtraChoiceResult()
}