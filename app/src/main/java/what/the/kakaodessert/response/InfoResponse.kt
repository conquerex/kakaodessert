package what.the.kakaodessert.response

import com.google.gson.annotations.SerializedName

data class InfoResponse(
    @SerializedName("photo") val photoInfo: PhotoInfo,
    @SerializedName("stat") val stat: String
)