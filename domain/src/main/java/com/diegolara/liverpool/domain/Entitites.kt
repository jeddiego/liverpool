package com.diegolara.liverpool.domain

import com.google.gson.annotations.SerializedName

data class ProductsModel(
    val id: String,
    val name: String,
    val image: String? = "",
    val priceWithDiscont: Double = 0.0,
    val priceWithoutDiscount: Double = 0.0,
    val variantsColor: List<VariantsColorDto>
)

data class ProductsResponseDto(
    @SerializedName("status") val statusDto: StatusDto,
    @SerializedName("plpResults") val plpResults: PlpResultsTdo
)

data class PlpResultsTdo(
    @SerializedName("records") val products: List<ProductsDto>?
)

data class ProductsDto(
    @SerializedName("productId") val productId: String,
    @SerializedName("productDisplayName") val productDisplayName: String,
    @SerializedName("listPrice") val listPrice: Double = 0.0,
    @SerializedName("minimumPromoPrice") val minimumPromoPrice: Double = 0.0,
    @SerializedName("variantsColor") val variantsColor: List<VariantsColorDto>,
    @SerializedName("xlImage") val xlImage: String
)

data class VariantsColorDto(
    @SerializedName("colorName") val colorName: String = "",
    @SerializedName("colorHex") val colorHex: String = ""
)

data class StatusDto(
    @SerializedName("status") val status: String,
    @SerializedName("statusCode") val statusCode: Int
)

fun ProductsDto.asProductsModel(): ProductsModel = ProductsModel(
    id = productId,
    name = productDisplayName,
    image = xlImage,
    priceWithDiscont = minimumPromoPrice,
    priceWithoutDiscount = listPrice,
    variantsColor = variantsColor
)