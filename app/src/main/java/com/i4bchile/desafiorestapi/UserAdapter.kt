package com.i4bchile.desafiorestapi


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.i4bchile.desafiorestapi.databinding.ItemListUserBinding

class UserAdapter: RecyclerView.Adapter<UserVH>() {

    val userList=mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val binding=ItemListUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserVH(binding)
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
            val user=userList[position]
            holder.bind(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateAdapter(pUserList:List<User>){
        userList.clear()
        userList.addAll(pUserList)
        notifyDataSetChanged()
    }

}


class UserVH(private val binding: ItemListUserBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind(user: User) {

        binding.tvName.text=user.name
        binding.tvEmail.text=user.email
        binding.tvPhone.text=user.phone

    }

}
