package com.diegolara.liverpool.data

import com.diegolara.liverpool.domain.ProductsModel
import com.diegolara.liverpool.domain.utils.Result
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getProductsByPage(page: Int): Result<List<ProductsModel>> = remoteDataSource.getData(page)
}