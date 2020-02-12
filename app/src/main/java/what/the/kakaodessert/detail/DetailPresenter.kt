package what.the.kakaodessert.detail

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import what.the.kakaodessert.ApiRequest
import what.the.kakaodessert.NetworkSetting
import what.the.kakaodessert.R
import what.the.kakaodessert.response.InfoResponse


class DetailPresenter : DetailContact.Presenter {

    override lateinit var view: DetailContact.View
    private val TAG = javaClass.simpleName
    private val apiRequest = NetworkSetting.getClient().create(
        ApiRequest::class.java
    )

    fun getInfo(photoId: String) {
        val key = (view as DetailActivity).resources.getString(R.string.flickr_key)

        apiRequest.getImageDetail(key, photoId).enqueue(object : Callback<InfoResponse> {
            override fun onFailure(call: Call<InfoResponse>, t: Throwable) {
                Log.d(TAG, "* * * onFailure : ${t.message}")
            }

            override fun onResponse(call: Call<InfoResponse>, response: Response<InfoResponse>) {
                response.body()?.let {
                    view.showInfo(it.photoInfo)
                }
            }
        })
    }
}