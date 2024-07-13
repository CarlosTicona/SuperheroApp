package com.example.superheroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerAdapter(this, getSuperheroes())
    }

    private fun getSuperheroes(): List<Superhero> {
        return listOf(
            Superhero("Clark Kent", "Superman", "DC",  R.drawable.superman),
            Superhero("Bruce Wayne", "Batman", "DC", R.drawable.batman),
            Superhero("Tony Stark", "Iron Man", "Marvel", R.drawable.ironman),
            Superhero("Peter Parker", "Spiderman", "Marvel", R.drawable.spiderman),
            Superhero("Mattnew Michael Murdock", "Daredevil", "Marvel", R.drawable.daredevil),
            Superhero("James Howlett", "Wolverine", "Marvel", R.drawable.wolverine),
            Superhero("Thor Odinson", "Thor", "Marvel", R.drawable.thor),
            Superhero("Jay Garrck", "Flash", "DC", R.drawable.flash),
            Superhero("Alan Scott", "Green Lantern", "DC", R.drawable.greenlantern),
            Superhero("Princess Diana", "Wonder Woman", "DC", R.drawable.wonderwoman)
        )
    }
}
