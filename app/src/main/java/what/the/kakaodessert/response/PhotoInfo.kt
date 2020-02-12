package what.the.kakaodessert.response

data class PhotoInfo(
    val dateuploaded: String,
    val title: Title,
    val id: String,
    val views: String,
    val owner: Owner,
    val farm: String,
    val server: String,
    val secret: String
)