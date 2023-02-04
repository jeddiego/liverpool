package com.diegolara.liverpool.usecases

import com.diegolara.liverpool.domain.ProductsModel
import com.diegolara.liverpool.data.ProductsRepository
import com.diegolara.liverpool.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsByPageUseCaseImpl @Inject constructor(
    private val repository: ProductsRepository
) : GetProductsByPageUseCase {
    override suspend fun invoke(page: Int): Result<List<ProductsModel>> = repository.getProductsByPage(page)
}

interface GetProductsByPageUseCase {
    suspend fun invoke(page: Int): Result<List<ProductsModel>>
}
