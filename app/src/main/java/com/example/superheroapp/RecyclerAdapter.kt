package com.example.superheroapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val context: Context, private val superheroList: List<Superhero>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val superheroLogo: ImageView = view.findViewById(R.id.superheroLogo)
        val realName: TextView = view.findViewById(R.id.realName)
        val superheroName: TextView = view.findViewById(R.id.superheroName)
        val companyName: TextView = view.findViewById(R.id.companyName)

        init {
            view.setOnClickListener {
                val superhero = superheroList[adapterPosition]
                val intent = Intent(context, SuperheroDetailsActivity::class.java).apply {
                    putExtra("superhero", superhero)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val superhero = superheroList[position]
        holder.realName.text = superhero.realName
        holder.superheroName.text = superhero.superheroName
        holder.companyName.text = superhero.companyName
        holder.superheroLogo.setImageResource(superhero.imageResourceId)
    }

    override fun getItemCount(): Int {
        return superheroList.size
    }
}
