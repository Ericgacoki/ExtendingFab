package com.ericg.extendedfab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ericg.extendedfab.databinding.ChatItemBinding

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(
            ChatItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }

    inner class ChatViewHolder(chatItem: ChatItemBinding) : RecyclerView.ViewHolder(chatItem.root) {

    }

}