package what.the.kakaodessert.detail

import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar.*
import what.the.kakaodessert.R
import what.the.kakaodessert.base.BaseActivity
import what.the.kakaodessert.base.BaseApplication
import what.the.kakaodessert.response.PhotoInfo
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : BaseActivity(),
    DetailContact.View {

    private val TAG = javaClass.simpleName
    lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        toolbarTextView.text = "Image Info"

        if (intent.hasExtra("photoId")) {
            presenter.run {
                BaseApplication.getInstance().progressON(this@DetailActivity)
                getInfo(intent.getStringExtra("photoId"))
            }
        }
    }

    override fun initPresenter() {
        presenter = DetailPresenter().apply {
            view = this@DetailActivity
        }
    }

    override fun showInfo(info: PhotoInfo) {
        // 이미지 URL
        val imageString = "https://farm${info.farm}.staticflickr.com" +
                "/${info.server}" +
                "/${info.id}_${info.secret}.jpg"

        Glide.with(this).load(imageString).into(imageDetail)
        textDetailTitle.text = info.title.content
        textDetailOwnerName.text = info.owner.realname
        textDetailOwnerLocation.text = info.owner.location
        textDetailViews.text = info.views
        textDetailUploadedDate.text =
            info.dateuploaded.toLongOrNull()?.let { convertLongToTime(it) }
        BaseApplication.getInstance().progressOFF()
    }

    fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy.MM.dd HH:mm")
        return format.format(date)
    }
}
