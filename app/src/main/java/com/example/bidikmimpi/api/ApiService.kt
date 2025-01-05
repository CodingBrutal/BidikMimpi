package com.example.bidikmimpi.api
import com.example.bidikmimpi.models.RegisterLogin
import com.example.bidikmimpi.models.StrukturLogin
import com.example.bidikmimpi.models.ResponseLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("api/v1/auth/login/")
    suspend fun login(@Body body: StrukturLogin): Response<ResponseLogin>

    @POST("api/v1/auth/register/")
    suspend fun register(@Body body: RegisterLogin): Response<ResponseLogin>

    @POST("api/v1/applicant")
    suspend fun getSomething(
        @Header("Authorization") authHeader: String
    ): Response<ResponseLogin>

}
