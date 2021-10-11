package com.bd_drmwan.githubusers.viewmodels

import androidx.lifecycle.viewModelScope
import com.bd_drmwan.githubusers.models.Resource
import com.bd_drmwan.githubusers.models.ResultSearchUsers
import com.bd_drmwan.githubusers.repositorys.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val appRepository: AppRepository): BaseViewModel() {

    private val _listUserByQuery = MutableStateFlow<Resource<ResultSearchUsers>>(Resource.Loading())
    val listUserByQuery get() = _listUserByQuery

    fun getUsersByUsername(query: String) {
        viewModelScope.launch {
            appRepository.getUsersByUsername(query)
                .onStart {
                    _listUserByQuery.value = Resource.Loading()
                }
                .catch {
                    val msgError = handleErrorResponse(it)
                    _listUserByQuery.value = Resource.Error(msgError)
                }
                .collect {
                    _listUserByQuery.value = Resource.Success(it)
                }
        }
    }
}