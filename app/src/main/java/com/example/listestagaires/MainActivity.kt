package com.example.listestagaires

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.listestagaires.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listViewVilles)
        val editVille = findViewById<EditText>(R.id.editVille)
        val btnAjouter = findViewById<Button>(R.id.btnAjouter)

        val villes = mutableListOf("Casablanca", "Rabat", "Marrakech", "Fès", "Tanger")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, villes)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Ville n°${position + 1} : ${villes[position]}", Toast.LENGTH_SHORT).show()
        }

        btnAjouter.setOnClickListener {
            val nouvelle = editVille.text.toString().trim()
            if (nouvelle.isNotEmpty()) {
                villes.add(nouvelle)
                adapter.notifyDataSetChanged()
                editVille.text.clear()
            }
        }
    }
}
