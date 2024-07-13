package com.example.superheroapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SuperheroDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_details)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val toolbarTitle: TextView = findViewById(R.id.toolbar_title)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val superhero = intent.getSerializableExtra("superhero") as? Superhero
        val superheroImage: ImageView = findViewById(R.id.superheroImage)

        superhero?.let {
            superheroImage.setImageResource(it.imageResourceId)
            toolbarTitle.text = "${it.superheroName} - ${it.realName}"
        }

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        // Obtener referencia al botón "Ver información"
        val viewInfoButton: Button = findViewById(R.id.viewInfoButton)

        // Configurar OnClickListener para el botón "Ver información"
        viewInfoButton.setOnClickListener {
            val intent = Intent(this@SuperheroDetailsActivity, HeroInfoActivity::class.java)
            intent.putExtra("superhero", superhero) // superhero es el objeto Superhero seleccionado
            startActivity(intent)
        }
    }
}
