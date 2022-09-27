package com.dev.msc.myjetpackcomposestudiesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.msc.myjetpackcomposestudiesapp.ui.theme.MyJetpackComposeStudiesAppTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackComposeStudiesAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val moneyValue = remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$${moneyValue.value}",
                style = TextStyle(
                    color = Color.LightGray,
                    fontSize = 34.sp
                )
            )
            Spacer(modifier = Modifier.height(130.dp))
            CreateCircle(moneyValue.value) {
                moneyValue.value += 1
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CreateCircle(moneyValue: Int = 0, updateClick: (Int) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(160.dp),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = {
            updateClick
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Tap", fontSize = 40.sp)
        }
    }
}

@Preview(device = Devices.PIXEL_2_XL)
@Composable
fun DefaultPreview2() {
    MyJetpackComposeStudiesAppTheme {
        MyApp()
    }
}