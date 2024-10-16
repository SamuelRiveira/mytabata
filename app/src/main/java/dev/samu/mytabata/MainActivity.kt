// MainActivity.kt
package dev.samu.mytabata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.samu.mytabata.ui.theme.MytabataTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MytabataTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier) {
    var theCounter by remember { mutableLongStateOf(0L) }

    val miCounterDown = CounterDown(99, { newCounterValue -> theCounter = newCounterValue})

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(text = theCounter.toString())
        }
        Row {
            Button(
                modifier = Modifier,
                onClick = {
                    if (!miCounterDown.counterState) {
                        miCounterDown.myCounter.start()
                        miCounterDown.counterState = true
                    } else {
                        miCounterDown.myCounter.cancel()
                        miCounterDown.counterState = false
                    }
                }
            ) {
                Text(text = if (miCounterDown.counterState) "Parar" else "Iniciar")
            }
        }
    }
}
