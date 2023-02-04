package com.diegolara.liverpool.data

import com.diegolara.liverpool.data.BuildConfig.CORE_API_VERSION
import com.diegolara.liverpool.domain.ProductsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductServices {

    @GET("${CORE_API_VERSION}/plp")
    suspend fun getProductsAsync(
        @Query("page-number") page: Int
    ): ProductsResponseDto
}