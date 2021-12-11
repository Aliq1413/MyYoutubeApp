package com.example.myyoutubeapp
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import kotlinx.android.synthetic.main.youtube_item.view.*

class YouTubeAdapter(
    private val videoList: Array<Array<String>>,
    private val player: YouTubePlayer): RecyclerView.Adapter<YouTubeAdapter.YouTubeViewHolder>(){
    class YouTubeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val button: Button = itemView.btVideo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YouTubeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.youtube_item,
            parent,
            false
        )
        return YouTubeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:YouTubeViewHolder, position: Int) {
        val currentTitle = videoList[position][0]
        val currentLink = videoList[position][1]
        holder.button.text = currentTitle
        holder.button.setOnClickListener {
            player.loadVideo(currentLink, 0f)
        }
    }

    override fun getItemCount() = videoList.size
}