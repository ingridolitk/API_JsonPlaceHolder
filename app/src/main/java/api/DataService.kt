package api

import model.Foto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DataService {

   @GET("/photos")
    fun recuperDados(@Path("photos") photos: String): Call<List<Foto>>

    @GET("/posts")
    fun recuperarPostagens(@Path("posts") photos: String): Call<List<Foto>>
}
