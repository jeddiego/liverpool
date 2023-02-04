package com.diegolara.liverpool.data

import com.diegolara.liverpool.domain.ProductsModel
import com.diegolara.liverpool.domain.asProductsModel
import com.diegolara.liverpool.domain.utils.RemoteDataSourceCall
import com.diegolara.liverpool.domain.utils.Result
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val services: ProductServices
): RemoteDataSource {
    override suspend fun getData(page: Int): Result<List<ProductsModel>> {
        return safeApiCall {
            services.getProductsAsync(page)
                .plpResults
                .products
                ?.map { it.asProductsModel() } ?: emptyList()
        }
    }
}

interface RemoteDataSource: RemoteDataSourceCall {
    suspend fun getData(page: Int): Result<List<ProductsModel>>
}
