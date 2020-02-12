package what.the.kakaodessert.main

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import what.the.kakaodessert.ApiRequest
import what.the.kakaodessert.NetworkSetting
import what.the.kakaodessert.R
import what.the.kakaodessert.response.ImagesResponse

class MainPresenter : MainContact.Presenter {

    override lateinit var view: MainContact.View
    private val TAG = javaClass.simpleName
    private val apiRequest = NetworkSetting.getClient().create(
        ApiRequest::class.java
    )

    fun getImages(page: Int) {
        val key = (view as MainActivity).resources.getString(R.string.flickr_key)

        apiRequest.getImages(page, key).enqueue(object : Callback<ImagesResponse> {
            override fun onFailure(call: Call<ImagesResponse>, t: Throwable) {
                Log.d(TAG, "* * * onFailure : ${t.message}")
            }

            override fun onResponse(
                call: Call<ImagesResponse>,
                response: Response<ImagesResponse>
            ) {
                response.body()?.let {
                    if (it.stat != "fail") {
                        view.showImages(it.photos)
                    }
                }
            }
        })
    }
}