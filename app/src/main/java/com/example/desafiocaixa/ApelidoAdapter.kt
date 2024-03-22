package com.example.desafiocaixa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ApelidoAdapter(private val apelidos: List<Data>) :
    RecyclerView.Adapter<ApelidoAdapter.ApelidoViewHolder>() {

    class ApelidoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtPat: TextView
        val txtApelido: TextView

        init {
            txtPat = view.findViewById(R.id.txt_pat)
            txtApelido = view.findViewById(R.id.txt_apelido)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ApelidoViewHolder {

        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.apelido_item, viewGroup, false)

        return ApelidoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return apelidos.size
    }

    override fun onBindViewHolder(viewHolder: ApelidoViewHolder, position: Int) {
        viewHolder.txtPat.text = "PAT: ${apelidos[position].pat}"
        viewHolder.txtApelido.text = apelidos[position].apelido
    }
}