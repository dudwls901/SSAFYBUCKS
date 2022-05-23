package com.ssafy.smartstore.data.remote

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.ssafy.admin_final_gumi0607_09.BuildConfig
import com.ssafy.admin_final_gumi0607_09.data.remote.api.OrderService
import com.ssafy.admin_final_gumi0607_09.data.remote.api.ProductService
import com.ssafy.smartstore.data.remote.api.*
import com.ssafy.smartstore.data.remote.dto.ErrorResponse
import com.ssafy.smartstore.util.Network.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    val userService: UserService by lazy {
        getRetrofit().create(UserService::class.java)
    }


    val tokenService: TokenService by lazy {
        getRetrofit().create(TokenService::class.java)
    }

    val productService: ProductService by lazy {
        getRetrofit().create(ProductService::class.java)
    }
    val orderService: OrderService by lazy {
        getRetrofit().create(OrderService::class.java)
    }


    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(buildOkHttpClient())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .setLenient()
                        .create()
                )
            )
            .build()
    }

    //okHttp 로그
    private fun buildOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        return OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    fun getErrorResponse(errorBody: ResponseBody): ErrorResponse? {
        return getRetrofit().responseBodyConverter<ErrorResponse>(
            ErrorResponse::class.java,
            ErrorResponse::class.java.annotations
        ).convert(errorBody)
    }
}