package com.bp.core_network.network.model

import com.bp.core_network.network.model.ErrorResponse
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.StatusCode.PayloadTooLarge
import com.skydoves.sandwich.mappers.ApiErrorModelMapper
import com.skydoves.sandwich.retrofit.apiMessage
import com.skydoves.sandwich.retrofit.statusCode
import org.json.JSONObject

object ErrorResponseMapper : ApiErrorModelMapper<ErrorResponse> {
    override fun map(apiErrorResponse: ApiResponse.Failure.Error): ErrorResponse {
        var message = "Something went wrong!"

        if(apiErrorResponse.statusCode != PayloadTooLarge) {
            message = JSONObject(apiErrorResponse.apiMessage)["message"].toString()
        }
        return ErrorResponse(apiErrorResponse.statusCode.code, message)
    }
}