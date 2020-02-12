package what.the.kakaodessert.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_main_list.view.*
import what.the.kakaodessert.response.Photo

class MainListItemHolder(view: View, parent: ViewGroup) : RecyclerView.ViewHolder(view) {

    private val TAG = javaClass.simpleName
    private val parent = parent

    var photo = itemView.imageMainItem
    var title = itemView.textMainItem

    fun bind(itemPhoto: Photo) {
        // 이미지 정사각형 만들기
        photo.layoutParams.height = parent.measuredWidth / 3

        // 이미지 URL
        val imageString = "https://farm${itemPhoto.farm}.staticflickr.com" +
                "/${itemPhoto.server}" +
                "/${itemPhoto.id}_${itemPhoto.secret}.jpg"

        if (imageString.isNotEmpty()) {
            Glide.with(itemView).load(imageString).into(photo)
            title.text = itemPhoto.title
            photo.visibility = View.VISIBLE
        } else {
            photo.visibility = View.GONE
        }
    }
}