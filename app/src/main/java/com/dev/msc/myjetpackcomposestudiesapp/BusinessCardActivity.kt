package com.dev.msc.myjetpackcomposestudiesapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.msc.myjetpackcomposestudiesapp.ui.theme.MyJetpackComposeStudiesAppTheme

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackComposeStudiesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    MyJetpackComposeStudiesAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(15.dp),
                shape = RoundedCornerShape(corner = CornerSize(20.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CreateImageProfile()
                    Divider(
                        color = Color.LightGray,
                        thickness = 2.dp,
                    )
                    CreateTitle()
                    Button(onClick = {
                        buttonClickedState.value = !buttonClickedState.value
                    }, modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)) {
                        Text(
                            "Portfolio",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    if (buttonClickedState.value) {
                        Content()
                    } else {
                        Box() {

                        }
                    }
                }
            }

        }
    }
}

@Composable
fun CreateImageProfile(
    modifier: Modifier = Modifier
        .size(220.dp)
        .padding(32.dp)
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
        shadowElevation = 4.dp,
        border = BorderStroke(0.5.dp, Color.LightGray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "profile image",
            modifier = Modifier.size(140.dp)
        )
    }
}

@Composable
fun CreateTitle(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Maria Augusta Silva",
            modifier = Modifier.padding(top = 26.dp, bottom = 10.dp),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Desenvolvedora android",
            modifier = Modifier.padding(vertical = 3.dp),
        )
        Text(
            text = "@maagustas",
            modifier = Modifier.padding(vertical = 0.dp),
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp))
        ) {
            Portfolio(data = listOf("Project1", "Project2", "Project3", "Project4"))
        }

    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RectangleShape,
            ) {
                Row(
                    modifier = Modifier
                        .padding(start = 6.dp, end = 6.dp, top = 6.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(8.dp)
                ) {
                    CreateImageProfile(modifier = Modifier.size(60.dp))
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "A great project", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyJetpackComposeStudiesAppTheme {
        BusinessCard()
    }
}