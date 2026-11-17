package com.example.listestagaires

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class StagiaireAdapter(
    private val context: Context,
    private val stagiaires: List<Stagiaire>
) : BaseAdapter() {

    private class ViewHolder(view: View) {
        val txtNom: TextView = view.findViewById(R.id.txtNom)
        val txtFiliere: TextView = view.findViewById(R.id.txtFiliere)
        val txtAge: TextView = view.findViewById(R.id.txtAge)
    }

    override fun getCount(): Int = stagiaires.size

    override fun getItem(position: Int): Stagiaire = stagiaires[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_stagiaire, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val stagiaire = stagiaires[position]
        holder.txtNom.text = stagiaire.nom
        holder.txtFiliere.text = stagiaire.filiere
        holder.txtAge.text = "${stagiaire.age} ans"

        if (stagiaire.age >= 25) {
            holder.txtAge.setTextColor(Color.parseColor("#2E7D32"))
        } else {
            holder.txtAge.setTextColor(Color.BLACK)
        }

        return view
    }
}
