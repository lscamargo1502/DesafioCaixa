package com.example.desafiocaixa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val posts: List<PostResponse>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtId: TextView
        val txtTitle: TextView
        val txtBody: TextView

        init {
            txtId = view.findViewById(R.id.txt_id)
            txtTitle = view.findViewById(R.id.txt_title)
            txtBody = view.findViewById(R.id.txt_body)
        }


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): PostViewHolder {

        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.post_item, viewGroup, false)

        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(viewHolder: PostViewHolder, position: Int) {
        viewHolder.txtId.text = posts[position].id.toString()
        viewHolder.txtTitle.text = posts[position].title
        viewHolder.txtBody.text = posts[position].body
    }


}