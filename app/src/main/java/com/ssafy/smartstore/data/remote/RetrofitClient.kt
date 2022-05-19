package com.ssafy.smartstore.data.remote

import com.android.volley.BuildConfig
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.ssafy.smartstore.data.remote.api.*
import com.ssafy.smartstore.util.Network.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    val productService: ProductService by lazy {
        getRetrofit().create(ProductService::class.java)
    }
    val orderService: OrderService by lazy{
        getRetrofit().create(OrderService::class.java)
    }

    val userService: UserService by lazy {
        getRetrofit().create(UserService::class.java)
    }

    val commentService: CommentService by lazy {
        getRetrofit().create(CommentService::class.java)
    }

    val tokenService: TokenService by lazy {
        getRetrofit().create(TokenService::class.java)
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
    private fun buildOkHttpClient(): OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor()

        if(BuildConfig.DEBUG){
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        else{
            loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        return OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

//    fun getErrorResponse(errorBody: ResponseBody): String?{
//        return getRetrofit().responseBodyConverter<String>()
//            String::class.java,
//            String::class.java.annotations
//    }.convert(errorBody)

}