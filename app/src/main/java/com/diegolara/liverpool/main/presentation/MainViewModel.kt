package com.diegolara.liverpool.main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegolara.liverpool.domain.ProductsModel
import com.diegolara.liverpool.domain.utils.Result
import com.diegolara.liverpool.usecases.GetProductsByPageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getProductsByPageUseCase: GetProductsByPageUseCase
): ViewModel() {

    val _getProductosByPage = MutableLiveData<List<ProductsModel>>()
    var getProductsByPage: LiveData<List<ProductsModel>> = _getProductosByPage

    fun getProductsByPage(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getProductsByPageUseCase.invoke(page)
            if (result is Result.Success) {
                val products = result.data
                if (products != null) {
                    _getProductosByPage.postValue(result.data!!)
                }
            }
        }
    }
}