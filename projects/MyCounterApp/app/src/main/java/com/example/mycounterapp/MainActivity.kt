package com.example.mycounterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycounterapp.ui.theme.MyCounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = CounterViewModel()
        setContent {
            MyCounterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun CounterApp(counterViewModel: CounterViewModel) {
    val count = remember {
        counterViewModel.count
    }

    Column {
        Button(onClick = { counterViewModel.increment() }) {
            Text(text = "Increment")
        }
        Button(onClick = { counterViewModel.decrement() }) {
            Text(text = "Decrement")
        }
        Text(text = "Count: $count")
    }
}