package com.example.superheroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.squareup.picasso.Picasso

class HeroInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_info)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val superhero = intent.getSerializableExtra("superhero") as? Superhero

        superhero?.let {
            supportActionBar?.title = "" // Limpiamos el título por defecto

            // Actualizamos el texto del encabezado con el nombre del héroe
            val toolbarTitle: TextView = findViewById(R.id.toolbar_title)
            toolbarTitle.text = "Información de ${it.superheroName}"

            val heroImage: ImageView = findViewById(R.id.heroImage)
            val heroName: TextView = findViewById(R.id.heroName)
            val realName: TextView = findViewById(R.id.realName)
            val heroDescription: TextView = findViewById(R.id.heroDescription)
            val companyName: TextView = findViewById(R.id.companyName)

            Picasso.get().load(it.imageResourceId).into(heroImage)
            heroName.text = it.superheroName
            realName.text = it.realName
            heroDescription.text = getHeroDescription(it.superheroName)
            companyName.text = it.companyName
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getHeroDescription(heroName: String): String {
        return when (heroName) {
            "Superman" -> "Superman es conocido por su identidad secreta como Clark Kent, un periodista del Daily Planet en Metrópolis. Es un superhéroe con una amplia gama de habilidades sobrehumanas, incluyendo fuerza, velocidad, visión de rayos X y vuelo. Su traje azul y rojo con la icónica 'S' en el pecho es reconocido en todo el mundo como símbolo de verdad, justicia y el estilo de vida americano."
            "Batman" -> "Batman es conocido por su identidad secreta como Bruce Wayne, un multimillonario filántropo de Ciudad Gótica. A diferencia de muchos superhéroes que poseen poderes sobrehumanos, Batman depende de su entrenamiento físico extremo, habilidades detective y vastos recursos tecnológicos para combatir el crimen. Su característico traje de murciélago negro y capa lo distingue, complementado por gadgets avanzados y el Batimóvil, un vehículo altamente equipado. Su enfoque en la justicia y su código moral riguroso lo han convertido en uno de los personajes más emblemáticos del género de superhéroes."
            "Iron Man" -> "Iron Man es conocido por su identidad secreta como Tony Stark, un genio inventor, empresario y filántropo. Stark utiliza una armadura de alta tecnología que le otorga fuerza sobrehumana, vuelo, y una variedad de armas y dispositivos avanzados. Aunque inicialmente era un fabricante de armas, Stark redirigió su tecnología para proteger al mundo como Iron Man, convirtiéndose en un miembro clave de los Vengadores y un defensor de la paz mundial."
            "Spiderman" -> "Spiderman es conocido por su identidad secreta como Peter Parker, un estudiante de secundaria que adquirió habilidades arácnidas después de ser picado por una araña radiactiva. Parker utiliza sus habilidades de agilidad, fuerza proporcional a la de una araña, y la capacidad de adherirse a las superficies para luchar contra el crimen en Nueva York. Su traje rojo y azul con una telaraña en el pecho es un símbolo icónico de su alter ego como Spiderman."
            "Daredevil" -> "Daredevil es conocido por su identidad secreta como Matt Murdock, un abogado ciego de día y vigilante de noche en Hell's Kitchen, Nueva York. Después de perder la vista en un accidente químico, Murdock desarrolló sentidos aumentados que le permiten detectar criminales y peligros a su alrededor. Utilizando sus habilidades de artes marciales y un bastón con habilidades especiales, Daredevil lucha contra la injusticia y protege a los inocentes."
            "Wolverine" -> "Wolverine es conocido por su identidad secreta como Logan, un mutante con habilidades regenerativas, garras retráctiles de adamantium y sentidos agudos. A menudo conocido por su actitud ruda y su pasado oscuro, Wolverine es un miembro clave de los X-Men y un guerrero solitario que lucha por la justicia y la supervivencia. Su regeneración rápida y su esqueleto reforzado de adamantium lo convierten en uno de los combatientes más formidables del universo Marvel."
            "Thor" -> "Thor es conocido por ser el dios del trueno y príncipe de Asgard, basado en la mitología nórdica. Posee fuerza sobrehumana, longevidad, y la habilidad de manipular el clima con su martillo encantado, Mjolnir. Thor es un miembro fundador de los Vengadores y defensor de los Nueve Reinos, luchando contra amenazas tanto terrenales como cósmicas con su valentía y honor como sus principales virtudes."
            "Flash" -> "Flash es conocido por su identidad secreta como Barry Allen, un científico forense con habilidades súper veloces después de ser alcanzado por un rayo y bañado en productos químicos. Utiliza su velocidad casi ilimitada para viajar en el tiempo, atravesar objetos sólidos y combatir criminales en Central City. El traje rojo y dorado de Flash con el rayo distintivo en el pecho lo convierte en uno de los héroes más rápidos del universo DC."
            "Green Lantern" -> "Green Lantern es conocido por su identidad secreta como Hal Jordan, un piloto de pruebas seleccionado por un anillo de poder extraterrestre que le otorga la capacidad de crear construcciones de luz sólida a partir de su fuerza de voluntad. Como miembro del Cuerpo de Green Lanterns, Hal protege el sector espacial 2814, incluyendo la Tierra, contra amenazas intergalácticas y cósmicas con su ingenio y valentía."
            "Wonder Woman" -> "Wonder Woman es conocida por su identidad secreta como Diana Prince, una princesa amazona con habilidades sobrehumanas otorgadas por los dioses del Olimpo. Es una guerrera experta en combate cuerpo a cuerpo, que porta el Lazo de la Verdad y otros artefactos místicos. Como embajadora de la paz y la justicia, Wonder Woman defiende los ideales de igualdad, compasión y verdad en el mundo moderno."
            else -> "Descripción no disponible."
        }
    }
}
