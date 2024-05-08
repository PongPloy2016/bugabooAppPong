package com.example.bugabooapppong.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bugabooapppong.repository.MainRepository
import com.example.bugabooapppong.data.model.MainResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class HomeViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _state = mutableStateOf<HomeViewState>(HomeViewState.Loading)
    val state: State<HomeViewState> = _state


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    val userList = MutableLiveData<MainResponse>()
    val errorMessage = MutableLiveData<String>()
    fun vmGetUserList () {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = mainRepository.repoGetListUsers()
                    userList.postValue(result)
                } catch (throwable: Throwable) {
                    when (throwable) {
                        is IOException -> {
                            errorMessage.postValue("Network Error")
                        }
                        is HttpException -> {
                            val codeError = throwable.code()
                            val errorMessageResponse = throwable.message()
                            errorMessage.postValue("Error $errorMessageResponse : $codeError")
                        }
                        else -> {
                            errorMessage.postValue("Uknown error")
                        }
                    }
                }
            }
        }
    }


    fun loadRandomRecipe() {
        viewModelScope.launch {
            _state.value = HomeViewState.Loading
            try {
                _state.value = HomeViewState.Success(
                     mainRepository.repoGetListUsers()

                )
            } catch(e: Exception) {
                _state.value = HomeViewState.Error("Error fetching recipe")
            }
        }
    }

//    val allUsers: LiveData<List<MainResponse>> = liveData {
//        val retrivedTodo = usersRepository.repoGetListUsers()
//        emit(retrivedTodo)
//    }
}