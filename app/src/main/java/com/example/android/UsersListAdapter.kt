package com.example.android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.databinding.ItemProductBinding
import com.squareup.picasso.Picasso


class UsersListAdapter(
    private val baseUrl: String,
    private var list: List<UserData>,
    private val lambda: (id: Int) -> Unit
) : RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ItemProductBinding // Убедитесь в правильном импорте
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(userData: UserData) {
            with(binding) {
                roomNumberView.text = userData.room_number.toString()
                documentView.text = userData.document_number

                root.setOnClickListener {
                    lambda(userData.room_number)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun update(newList: List<UserData>) {
        list = newList
        notifyDataSetChanged()
    }
}
