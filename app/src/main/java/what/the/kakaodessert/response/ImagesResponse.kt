package what.the.kakaodessert.response

import com.google.gson.annotations.SerializedName

data class ImagesResponse(
    @SerializedName("photos") val photos : Photos,
    @SerializedName("stat") val stat : String
)