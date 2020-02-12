package what.the.kakaodessert.response

import com.google.gson.annotations.SerializedName

data class Title(
    @SerializedName("_content") val content: String
)