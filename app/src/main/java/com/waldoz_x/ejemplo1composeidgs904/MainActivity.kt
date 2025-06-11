package com.waldoz_x.ejemplo1composeidgs904

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.Ejemplo1ComposeIDGS904Theme

// Definición de una clase de datos para representar un personaje
//data class es una clase que se usa para almacenar datos
data class PersonajeTarjeta(val title: String, val body: String)

// Lista de personajes creada con datos de ejemplo
private val tarjetas:List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla"),
    PersonajeTarjeta("vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters. A pesar de que a inicios de Dragon Ball Z, Vegeta cumple un papel antagónico, poco después decide rebelarse ante el Imperio de Freeza, volviéndose un aliado clave para los Guerreros Z"),
    PersonajeTarjeta("freezer", "Freezer es el tirano espacial y el principal antagonista de la saga de Freezer"),
    PersonajeTarjeta("gohan", "Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT"),
    PersonajeTarjeta("android17", "Antes de ser secuestrado, es el hermano mellizo de la Androide Número 18, quien al igual que ella antes de ser Androide era un humano normal hasta que fueron secuestrados por el Dr. Gero, y es por eso que lo odian"),
    PersonajeTarjeta("bills", "Dios de la Destrucción Beerus, conocido también como Beers, o Bills en Hispanoamérica e inicialmente en España[1], es un personaje que fue introducido en la película Dragon Ball Z: La batalla de los dioses, donde es el antagonista principal de la película"),
    PersonajeTarjeta("jiren", "Jiren es un poderoso luchador del Universo 11 y uno de los oponentes más formidables en el torneo"),
    PersonajeTarjeta("vegetto", "Vegetto es el personaje más fuerte dentro del manga original y uno de los personajes más poderosos de toda la serie en general. Su poder es el resultado del máximo poder combinado de Goku y Vegeta"),
    PersonajeTarjeta("broly", "Broly es un Saiyajin que posee un poder gigantesco e incontrolable, el cual se manifiesta en toda su magnitud cuando se convierte en el Super Saiyajin Legendario"),
    PersonajeTarjeta("gogeta", "Gogeta es la fusión resultante de Son Goku y Vegeta, cuando realizan la Danza de la Fusión correctamente para enfrentarse a Broly.")

)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            Ejemplo1ComposeIDGS904Theme {
           Tarjeta(tarjetas)

        }
    }
}




@Composable
fun MessageCard(name: String) {
    Text("HOLA MUNDO $name")
    Text("HOLA MUNDO $name")

}
@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>) {
    LazyColumn(
        modifier = Modifier
            .padding(24.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(personajes) { personaje ->
            MyPersonaje(personaje = personaje)
        }

    }
}


    @Composable
    fun MyPersonaje(personaje: PersonajeTarjeta) {
        Card(
            modifier = Modifier
                .padding(vertical = 8.dp) // Ajusta el padding vertical de la Card si es necesario
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            // Añadimos un Row aquí para organizar ImagenHero y Personajes horizontalmente
            Row(
                modifier = Modifier
                    .padding(16.dp) // Padding interno para el contenido del Row dentro de la Card
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically, // Alinea los hijos verticalmente al centro
                horizontalArrangement = Arrangement.spacedBy(16.dp) // Espacio horizontal entre ImagenHero y Personajes
            ) {
                ImagenHero(imageName = personaje.title) // Se mostrará a la izquierda

                // Personajes ocupará el espacio restante gracias al Column interno con fillMaxWidth si lo tuviera,
                // o se ajustará a su contenido.
                // Si quieres que Personajes tome más espacio, puedes usar pesos (weights) en el Row,
                // pero para este caso, Arrangement.spacedBy y la alineación suelen ser suficientes.
                Personajes(personaje = personaje) // Se mostrará a la derecha de ImagenHero
            }
        }
    }
@Composable
fun Personajes(personaje: PersonajeTarjeta){
    Column{
        Personaje(personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleLarge)
        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyMedium)
    }}


@Composable
private fun AnimatedContentSimple() {
    // [START android_compose_animations_animated_content_simple]
    Row {
        var count by remember { mutableIntStateOf(0) }
        Button(onClick = { count++ }) {
            Text("Add")
        }
        AnimatedContent(
            targetState = count,
            label = "animated content"
        ) { targetCount ->
            // Make sure to use `targetCount`, not `count`.
            Text(text = "Count: $targetCount")
        }
    }
    // [END android_compose_animations_animated_content_simple]
}


}

@Composable
fun ImagenHero(imageName: String){
    val context = LocalContext.current
    val ImageResourceId = remember(imageName){
        context.resources.getIdentifier(imageName, "drawable", context.packageName)
    }
    Image(
        painterResource(id= ImageResourceId),
        contentDescription = imageName,
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun Personaje(name: String,color: Color, style: TextStyle){

    Column(){
        Text(text=name)

    }



}

