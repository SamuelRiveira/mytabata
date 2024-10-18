package dev.samu.mytabata

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import dev.samu.mytabata.ui.theme.MytabataTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MytabataTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

var sets: Int = 0
var tiempoWork: Int = 0
var tiempoReset: Int = 0

@Composable
fun PantallaPrincipal(
    modifier: Modifier,
    onStartClicked: () -> Unit // Función que se llama cuando se presiona el botón
) {

    var timeWork by remember { mutableStateOf(0) }
    var timeReset by remember { mutableStateOf(0) }
    var timeSets by remember { mutableStateOf(0) }

    Column {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(36.dp)
        ) {
            Text(text = "Tabata", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            //Sets
            Row {
                Column(
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Sets",
                            fontSize = 25.sp,
                            modifier = Modifier
                                .padding(bottom = 16.dp
                            )

                        )
                    }
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                        Row {
                            Icon(
                                painter = painterResource(R.drawable.arriba),
                                contentDescription = "Flecha hacia abajo",
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                                    .clickable {
                                        sets++
                                        timeSets++
                                    }
                            )
                        }

                        Row {
                            Text(
                                text = "$timeSets",
                                fontSize = 28.sp
                            )
                        }

                        Row {
                            Icon(
                                painter = painterResource(R.drawable.abajo),
                                contentDescription = "Flecha hacia arriba",
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                                    .clickable {
                                        if (sets > 0) {
                                            sets--
                                            timeSets--
                                        }
                                    }
                            )
                        }
                    }
                }
            }
            //Work
            Row {
                Column(
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Work",
                            fontSize = 25.sp,
                            modifier = Modifier
                                .padding(bottom = 16.dp)
                        )
                    }
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                        Row {
                            Icon(
                                painter = painterResource(R.drawable.arriba),
                                contentDescription = "Flecha hacia arriba",
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                                    .clickable {
                                        tiempoWork += 60
                                        timeWork += 60
                                    }
                            )
                            Icon(
                                painter = painterResource(R.drawable.arriba),
                                contentDescription = "Flecha hacia abajo",
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                                    .clickable {
                                        tiempoWork++
                                        timeWork++
                                    }
                            )
                        }

                        Row {
                            Text(
                                text = String.format("%02d:%02d", timeWork / 60, timeWork % 60),
                                fontSize = 28.sp
                            )
                        }

                        Row {
                            Icon(
                                painter = painterResource(R.drawable.abajo),
                                contentDescription = "Flecha hacia abajo",
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                                    .clickable {
                                        if (tiempoWork >= 60) {
                                            tiempoWork -= 60
                                            timeWork -= 60
                                        }
                                    }
                            )
                            Icon(
                                painter = painterResource(R.drawable.abajo),
                                contentDescription = "Flecha hacia arriba",
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                                    .clickable {
                                        if (tiempoWork > 0) {
                                            tiempoWork --
                                            timeWork--
                                        }
                                    }
                            )
                        }
                    }
                }
            }
            //Reset
            Row {
                Column(
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Reset",
                            fontSize = 25.sp,
                            modifier = Modifier
                                .padding(bottom = 16.dp)
                        )
                    }
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                        Row {
                            Icon(
                                painter = painterResource(R.drawable.arriba),
                                contentDescription = "Flecha hacia arriba",
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                                    .clickable {
                                        tiempoReset += 60
                                        timeReset += 60
                                    }
                            )
                            Icon(
                                painter = painterResource(R.drawable.arriba),
                                contentDescription = "Flecha hacia abajo",
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                                    .clickable {
                                        tiempoReset++
                                        timeReset++
                                    }
                            )
                        }

                        Row {
                            Text(
                                text = String.format("%02d:%02d", timeReset / 60, timeReset % 60),
                                fontSize = 28.sp
                            )
                        }

                        Row {
                            Icon(
                                painter = painterResource(R.drawable.abajo),
                                contentDescription = "Flecha hacia abajo",
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                                    .clickable {
                                        if (tiempoReset >= 60) {
                                            tiempoReset -= 60
                                            timeReset -= 60
                                        }
                                    }
                            )
                            Icon(
                                painter = painterResource(R.drawable.abajo),
                                contentDescription = "Flecha hacia arriba",
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                                    .clickable {
                                        if (tiempoReset > 0) {
                                            tiempoReset--
                                            timeReset--
                                        }
                                    }
                            )
                        }
                    }
                }
            }
            //Button
            Row {
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        onStartClicked()
                    }
                ) {
                    Text(text = "Start", fontSize = 20.sp)
                }
            }
        }
    }
}

@Composable
fun AppContent(modifier: Modifier) {
    var showWork by remember { mutableStateOf(false) }
    var showPantallaPrincipal by remember { mutableStateOf(true) }
    var remainingSets by remember { mutableStateOf(sets) }
    var isLastSet by remember { mutableStateOf(false) }
    var resetCompleted by remember { mutableStateOf(false) }

    // Función para manejar la finalización del trabajo
    val handleWorkCompletion = {
        if (remainingSets > 0) {
            showWork = false
            Log.i("AppContent", "Work terminado, sets restantes: $remainingSets")
            if (remainingSets == 1) {
                isLastSet = true // Marcar el último set
            }
        }
    }

    // Función para manejar la finalización del reset
    val handleResetCompletion = {
        if (!isLastSet) {
            if (!resetCompleted) {
                remainingSets-- // Decrementa los sets restantes
                resetCompleted = true // Marca que el reset se ha completado
                Log.i("AppContent", "Reset terminado, sets restantes: $remainingSets")
            }
            showWork = true
        } else {
            remainingSets = sets
            isLastSet = false
            showPantallaPrincipal = true
            resetCompleted = false // Reinicia la variable de estado para el próximo ciclo
            Log.i("AppContent", "Todos los sets completados, reiniciando.")
        }
    }

    if (showPantallaPrincipal) {
        PantallaPrincipal(
            modifier = modifier,
            onStartClicked = {
                remainingSets = sets
                showPantallaPrincipal = false
                showWork = true
                resetCompleted = false // Asegúrate de reiniciar el estado al comenzar
                Log.i("AppContent", "Reiniciando sets y mostrando Work")
            }
        )
        sets = 0
        tiempoWork = 0
        tiempoReset = 0
        Log.i("AppContent", "Mostrando PantallaPrincipal, sets completados.")
    } else {
        if (showWork) {
            Log.i("AppContent", "Mostrando Work")
            // Aquí deberías llamar a la función que maneja el trabajo, asegurándote de invocar handleWorkCompletion cuando termine
            Work(modifier = Modifier, onWorkCompleted = handleWorkCompletion)
        } else {
            Log.i("AppContent", "Mostrando Reset")
            // Similarmente, maneja la lógica para el reset
            Reset(modifier = Modifier, onResetCompleted = handleResetCompletion as () -> Int)
        }
    }
}

@Composable
fun Work(
    modifier: Modifier = Modifier,
    onWorkCompleted: () -> Unit // Callback para cuando termine el tiempo de Work
) {
    tiempoWork += 1
    var theCounter by remember { mutableStateOf(String.format("%02d:%02d", tiempoWork / 60, tiempoWork % 60)) }

    var texto by remember { mutableStateOf("Pause") }

    // Usamos `remember` para crear y mantener `miCounterDown` durante el ciclo de vida del Composable
    val miCounterDown = remember {
        CounterDown(tiempoWork) { newValue ->
            theCounter = newValue
            if (newValue == "00:00") {
                onWorkCompleted() // Cuando el contador llegue a 0, llamamos a onWorkCompleted
            }
        }
    }

    miCounterDown.start()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFC876FF)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = theCounter,
            color = Color.White,
            fontSize = 80.sp
        )
        Text(
            text = "Work",
            color = Color.White,
            fontSize = 50.sp,
            modifier = Modifier
                .padding(36.dp)
        )
        Button(
            onClick = {
                Log.i("error", "Botón pulsado")
                miCounterDown.toggle()
                if (texto == "Start"){
                    texto = "Pause"
                } else{
                    texto = "Start"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(36.dp)
        ) {
            Text(text = texto)
        }
    }
}

@Composable
fun Reset(
    modifier: Modifier = Modifier,
    onResetCompleted: () -> Int // Callback para cuando termine el tiempo de Reset
) {
    tiempoReset += 1
    var theCounter by remember { mutableStateOf(String.format("%02d:%02d", tiempoReset / 60, tiempoReset % 60)) }

    var texto by remember { mutableStateOf("Pause") }

    // Usamos `remember` para crear y mantener `miCounterDown` durante el ciclo de vida del Composable
    val miCounterDown = remember {
        CounterDown(tiempoReset) { newValue ->
            theCounter = newValue
            if (newValue == "00:00") {
                onResetCompleted() // Cuando el contador llegue a 0, llamamos a onResetCompleted
            }
        }
    }

    miCounterDown.start()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEF4C0)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = theCounter,
            fontSize = 80.sp
        )
        Text(
            text = "Reset",
            fontSize = 50.sp,
            modifier = Modifier
                .padding(36.dp)
        )
        Button(
            onClick = {
                Log.i("error", "Botón pulsado")
                miCounterDown.toggle()
                if (texto == "Start"){
                    texto = "Pause"
                } else{
                    texto = "Start"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(36.dp)
        ) {
            Text(text = texto)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabataPreview() {
    MytabataTheme {
        AppContent(modifier = Modifier)
    }
}
