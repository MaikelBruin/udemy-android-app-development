package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import java.time.format.TextStyle
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {
    val millimetersString = "Millimeters"
    val centimetersString = "Centimeters"
    val metersString = "Meters"
    val feetString = "Feet"
    var inputValue by remember {
        mutableStateOf("")
    }
    var outputValue by remember {
        mutableStateOf("")
    }
    var inputUnit by remember {
        mutableStateOf(centimetersString)
    }
    var outputUnit by remember {
        mutableStateOf(metersString)
    }
    var inputExpanded by remember {
        mutableStateOf(false)
    }
    var outputExpanded by remember {
        mutableStateOf(false)
    }
    var inputConversionFactor = remember {
        mutableStateOf(0.01)
    }
    var outputConversionFactor = remember {
        mutableStateOf(1.00)
    }

    val customStyle = androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Monospace,
        fontSize = 16.sp,
        color = Color.Cyan
    )

    fun convertUnits() {
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result =
            (inputValueDouble * inputConversionFactor.value * 100.0 / outputConversionFactor.value).roundToInt() / 100
        outputValue = result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Unit Converter", style = customStyle)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it
                convertUnits()
            },
            label = { Text(text = "Enter value") }
        )
        Row {
            Box {
                Button(onClick = { inputExpanded = true }) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow down")
                }
                DropdownMenu(
                    expanded = inputExpanded,
                    onDismissRequest = { inputExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text(text = millimetersString) },
                        onClick = {
                            inputExpanded = false
                            inputUnit = millimetersString
                            inputConversionFactor.value = 0.001
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text(text = centimetersString) },
                        onClick = {
                            inputExpanded = false
                            inputUnit = centimetersString
                            inputConversionFactor.value = 0.01
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text(text = metersString) },
                        onClick = {
                            inputExpanded = false
                            inputUnit = metersString
                            inputConversionFactor.value = 1.00
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text(text = feetString) },
                        onClick = {
                            inputExpanded = false
                            inputUnit = feetString
                            inputConversionFactor.value = 0.3048
                            convertUnits()
                        })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = { outputExpanded = true }) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow down")
                }
                DropdownMenu(
                    expanded = outputExpanded,
                    onDismissRequest = { outputExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text(text = millimetersString) },
                        onClick = {
                            outputExpanded = false
                            outputUnit = millimetersString
                            outputConversionFactor.value = 0.001
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text(text = centimetersString) },
                        onClick = {
                            outputExpanded = false
                            outputUnit = centimetersString
                            outputConversionFactor.value = 0.01
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text(text = metersString) },
                        onClick = {
                            outputExpanded = false
                            outputUnit = metersString
                            outputConversionFactor.value = 1.00
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = {
                            outputExpanded = false
                            outputUnit = feetString
                            outputConversionFactor.value = 0.3048
                            convertUnits()
                        })
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Result: $outputValue $outputUnit",
            modifier = Modifier.padding(20.dp),
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}