package com.example.superheroapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val splashTimeOut: Long = 2000 // Tiempo en milisegundos (2 segundos)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // Después del tiempo de espera, iniciar MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Cierra la actividad actual
        }, splashTimeOut)
    }
}
