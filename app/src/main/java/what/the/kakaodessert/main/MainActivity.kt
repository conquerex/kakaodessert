package what.the.kakaodessert.main

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import what.the.kakaodessert.R
import what.the.kakaodessert.base.BaseActivity
import what.the.kakaodessert.base.BaseApplication
import what.the.kakaodessert.response.Photos

class MainActivity : BaseActivity(),
    MainContact.View {
    private val TAG = javaClass.simpleName
    lateinit var presenter: MainPresenter

    var page = 1
    var statusNextPage = true
    var listAdapter = MainListAdapter(this)

    override fun initPresenter() {
        presenter = MainPresenter().apply {
            view = this@MainActivity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbarTextView.text = "Search Dessert Image"

        listAdapter.setHasStableIds(true)

        // 가로줄 기준 : 이미지를 3개로 세팅
        listMain.layoutManager = GridLayoutManager(this@MainActivity, 3)
        listMain.adapter = listAdapter

        BaseApplication.getInstance().progressON(this)
        presenter.getImages(page)
    }

    override fun showImages(photos: Photos) {
        setAdapter(photos)
        this@MainActivity.page = page + 1
        statusNextPage = true
        BaseApplication.getInstance().progressOFF()
    }

    private fun setAdapter(photos: Photos) {
        listAdapter.addImages(photos.photo)

        listMain.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // 마지막 페이지인지 체크
                if (photos.page * (photos.perpage - 1) > photos.total) {
                    return
                }

                val layoutManager = recyclerView.layoutManager as GridLayoutManager
                val totalItemCount = layoutManager.itemCount
                val pastVisiblesItems = layoutManager.findFirstVisibleItemPosition()

                if (statusNextPage) {
                    if (pastVisiblesItems >= totalItemCount - 24) {
                        statusNextPage = false
                        BaseApplication.getInstance().progressON(this@MainActivity)
                        presenter.getImages(page)
                    }
                }
            }
        })
    }
}
