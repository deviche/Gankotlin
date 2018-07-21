package website.lizihanglove.newbee.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.ViewGroup
import com.bumptech.glide.module.AppGlideModule
import website.lizihanglove.newbee.R
import website.lizihanglove.newbee.java.GlideApp
import website.lizihanglove.newbee.model.ReadItem

class ReadAdapter(private val readItems: ArrayList<ReadItem>, val context: Context)
    : RecyclerView.Adapter<ReadHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadHolder {
        val readView = R.layout.item_read_view
        val view = LayoutInflater.from(context).inflate(readView, parent, false)
        return ReadHolder(view)
    }

    override fun getItemCount(): Int {
        return readItems.size
    }

    override fun onBindViewHolder(holder: ReadHolder, position: Int) {
        val readItem = readItems[position]
        holder.title.text = readItem.title
        holder.time.text = readItem.created_at.replace("T"," ").replace("Z"," ")
        GlideApp.with(context)
                .load(readItem.site.icon)
                .placeholder(R.drawable.empty)
                .into(holder.logo)
    }

    fun add(readItems: ArrayList<ReadItem>) {
        var size = this.readItems.size
        this.readItems.addAll(readItems)
        notifyItemRangeChanged(size, this.readItems.size)
    }
}
