package com.example.calculator_v20
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator_v20.DataClass.News
import com.example.calculator_v20.databinding.RecyclerviewItemBinding


class RecyclerAdapter(private val newsItemList: MutableList<News>, private val context:Context) : RecyclerView
.Adapter<RecyclerAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val newsItem = newsItemList[position]
        holder.bind(newsItem)
    }

    override fun getItemCount(): Int {
        return newsItemList.size
    }


    class MyViewHolder(recyclerviewItemBinding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(recyclerviewItemBinding.root) {

        private val binding = recyclerviewItemBinding

        fun bind(newsItem: News){
            binding.tvTitle.text = newsItem.Tittle
            binding.tvDescription.text = newsItem.Description
            binding.tvPublishedAt.text = newsItem.Time
            binding.tvSource.text = newsItem.Source
            binding.ivArticleImage.setImageResource(newsItem.Photo)
        }

    }
}
