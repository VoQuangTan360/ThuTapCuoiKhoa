package com.example.thuctapcuoiky.data.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thuctapcuoiky.R
import com.example.thuctapcuoiky.UI.Home.ReviewProductFragment
import com.example.thuctapcuoiky.data.model.Search
import com.example.thuctapcuoiky.databinding.EmptyItemBinding
import com.example.thuctapcuoiky.databinding.SearchItemBinding
import com.google.api.Property
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.withContext

@SuppressLint("NotifyDataSetChanged")
class SearchAdapter(
    private val itemList: List<Search> = listOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemOnclick: ((Search)->Unit)?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            Search.ItemType.TAG.value -> TagViewHolder(
                SearchItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> EmptyViewHolder(
                EmptyItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemList[position]
        when {
            holder is TagViewHolder && item is Search.Tag -> holder.bindData(item)
        }

        holder.itemView.setOnClickListener {
            onItemOnclick?.invoke(item)
        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int = itemList[position].itemType.value

    class TagViewHolder(private val itemTitleBinding: SearchItemBinding) : RecyclerView.ViewHolder(itemTitleBinding.root) {
        fun bindData(title: Search.Tag) {
//            itemTitleBinding.hashTag.text = title.tag
            itemTitleBinding.noOfPosts.text = title.number
            itemTitleBinding.txtName.text = title.tag
            Glide.with(itemTitleBinding.root)
            .load(title.url).into(itemTitleBinding.hashTag);

        }
    }


    class EmptyViewHolder(binding: EmptyItemBinding) : RecyclerView.ViewHolder(binding.root)
}
