package com.mobile.bluepillow.network.model

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.mappers.ApiErrorModelMapper
import com.skydoves.sandwich.message
import com.skydoves.sandwich.retrofit.apiMessage
import com.skydoves.sandwich.retrofit.errorBody
import com.skydoves.sandwich.retrofit.statusCode
import org.json.JSONObject
import retrofit2.Response

/**
 * A mapper for mapping [ApiResponse.Failure.Error] response as custom [ErrorRe] instance.
 *
 * @see [ApiErrorModelMapper](https://github.com/skydoves/sandwich#apierrormodelmapper)
 */
object ErrorResponseMapper : ApiErrorModelMapper<ErrorResponse> {

    /**
     * maps the [ApiResponse.Failure.Error] to the [PokemonErrorResponse] using the mapper.
     *
     * @param apiErrorResponse The [ApiResponse.Failure.Error] error response from the network request.
     * @return A customized [PokemonErrorResponse] error response.
     */
    override fun map(apiErrorResponse: ApiResponse.Failure.Error): ErrorResponse {
        val message = JSONObject(apiErrorResponse.apiMessage)["message"]
        return ErrorResponse(apiErrorResponse.statusCode.code, message.toString())
    }
}