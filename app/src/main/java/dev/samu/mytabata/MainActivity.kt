package dev.samu.mytabata

import android.os.Bundle
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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Calendar
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
//                    PantallaPrincipal (
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    Counter (
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaPrincipal(
    modifier: Modifier
){
    var timeReset by remember { mutableStateOf(0) }
    var timeSet by remember { mutableStateOf(0) }
    var timeWork by remember { mutableStateOf(0) }

    Column {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Tabata", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
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
                        Text(text = "Sets", fontSize = 25.sp)
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier.run {
                                clickable{
                                    if (timeSet > 0){
                                        timeSet--
                                    }
                                }
                                .padding(10.dp)
                            },
                            text = "-",
                            fontSize = 25.sp
                        )
                        Text(text = "$timeSet", fontSize = 25.sp)
                        Text(
                            modifier = Modifier.run {
                                clickable{
                                    timeSet++
                                }
                                .padding(10.dp)
                            },
                            text = "+",
                            fontSize = 25.sp
                        )
                    }
                }
            }
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
                        Text(text = "Work", fontSize = 25.sp)
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier.run {
                                clickable{
                                    if (timeWork > 0){
                                        timeWork--
                                    }
                                }
                                    .padding(10.dp)
                            },
                            text = "-",
                            fontSize = 25.sp
                        )
                        Text(text = "$timeWork", fontSize = 25.sp)
                        Text(
                            modifier = Modifier.run {
                                clickable{
                                    timeWork++
                                }
                                    .padding(10.dp)
                            },
                            text = "+",
                            fontSize = 25.sp
                        )
                    }
                }
            }
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
                        Text(text = "Reset", fontSize = 25.sp)
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier.run {
                                clickable{
                                    if (timeReset > 0){
                                        timeReset--
                                    }
                                }
                                    .padding(10.dp)
                            },
                            text = "-",
                            fontSize = 25.sp
                        )
                        Text(text = "$timeReset", fontSize = 25.sp)
                        Text(
                            modifier = Modifier.run {
                                clickable{
                                    timeReset++
                                }
                                    .padding(10.dp)
                            },
                            text = "+",
                            fontSize = 25.sp
                        )
                    }
                }
            }
            Row {
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {}
                ) {
                    Text(text = "Start", fontSize = 20.sp)
                }
            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier) {
    var theCounter by remember { mutableStateOf("00:00") }
    val miCounterDown = remember { CounterDown(99) { newValue ->
        theCounter = miCounterDown.getFormattedTime()
    } }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = theCounter,
            fontSize = 50.sp,
            modifier = modifier
        )
        Button(onClick = {
            miCounterDown.toggle()
        }) {
            Text(text = if (miCounterDown.isStarted) "Pause" else "Start")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabataPreview() {
    MytabataTheme {
//        PantallaPrincipal(modifier = Modifier)
        Counter(modifier = Modifier)
    }
}