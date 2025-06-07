package com.waldoz_x.ejemplo1composeidgs904

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waldoz_x.ejemplo1composeidgs904.ui.theme.Ejemplo1ComposeIDGS904Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            Ejemplo1ComposeIDGS904Theme {
           Tarjeta()

        }
    }
}




@Composable
fun MessageCard(name: String) {
    Text("HOLA MUNDO $name")
    Text("HOLA MUNDO $name")

}
data class Personajes(val nombre: String, val descripcion: String)
@Composable
fun Tarjeta(){
Row(modifier = Modifier
    .padding(24.dp)
    .background(MaterialTheme.colorScheme.background)) {

    ImagenHero()
    Personaje()
    AnimatedContentSimple()
}
}

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
fun ImagenHero(){
    Image(
        painterResource(id = R.drawable.img_5),
        contentDescription = stringResource(R.string.description),
        modifier = Modifier
        .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun Personaje(){

    Column(modifier = Modifier
        .padding(16.dp)
        .size(200.dp)
    ){
        Text("Nombre: Vegetto")
        Text("Descripcion: Vegetto es el personaje más fuerte dentro del manga original ")

    }



}

@Preview
@Composable
fun previewTarjeta(){
    ImagenHero()

}




