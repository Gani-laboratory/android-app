package com.reyuki.dicodingandroidapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reyuki.dicodingandroidapp.databinding.ActivityArticleItemBinding

class ListArticleAdapter(private val list: ArrayList<Article>, private val onClick: (Article) -> Unit) : RecyclerView.Adapter<ListArticleAdapter.ListViewHolder>() {
    inner class ListViewHolder(var binding: ActivityArticleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            itemView.setOnClickListener {
                onClick(article)
            }
        }
    }

    override fun getItemCount(): Int = list.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ActivityArticleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, content, cover) = list[position]
        holder.binding.imgItemPhoto.setImageResource(cover)
        holder.binding.tvItemTitle.text = title
        holder.binding.tvItemContent.text = content

        holder.bind(list[position])
    }
}