package what.the.kakaodessert.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import  what.the.kakaodessert.R
import what.the.kakaodessert.detail.DetailActivity
import what.the.kakaodessert.response.Photo

class MainListAdapter(context: Context) : RecyclerView.Adapter<MainListItemHolder>() {

    private val TAG = javaClass.simpleName
    private val context: Context = context
    var images = ArrayList<Photo>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListItemHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_list, parent, false)
        return MainListItemHolder(view, parent)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: MainListItemHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("photoId", images[position].id)
            context.startActivity(intent)
        }
        holder.bind(images[position])
    }

    override fun getItemId(position: Int): Long {
        return images[position].id.toLong()
    }

    fun addImages(imgs: ArrayList<Photo>) {
        for (i in 1..imgs.size) {
            images.add(imgs[i - 1])
        }
        notifyDataSetChanged()
    }
}