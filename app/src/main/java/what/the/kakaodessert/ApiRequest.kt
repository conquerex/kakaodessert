package what.the.kakaodessert

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import what.the.kakaodessert.response.ImagesResponse
import what.the.kakaodessert.response.InfoResponse

interface ApiRequest {

    @GET("services/rest/")
    fun getImages(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String,
        @Query("method") query: String = "flickr.photos.search",
        @Query("text") text: String = "'dessert'",
        @Query("per_page") perPage: String = "40",
        @Query("format") format: String = "json",
        @Query("nojsoncallback") nojsoncallback: String = "1"
    ): Call<ImagesResponse>

    @GET("services/rest/")
    fun getImageDetail(
        @Query("api_key") apiKey: String,
        @Query("photo_id") photoId: String,
        @Query("method") query: String = "flickr.photos.getInfo",
        @Query("format") format: String = "json",
        @Query("nojsoncallback") nojsoncallback: String = "1"
    ): Call<InfoResponse>
}