package com.dev.msc.myjetpackcomposestudiesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
    MyJetpackComposeStudiesAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Card(
                modifier = Modifier
                    .width(400.dp)
                    .height(400.dp)
                    .padding(15.dp),
                shape = RoundedCornerShape(corner = CornerSize(20.dp))
            ) {
                Column(
                    modifier = Modifier
                        .width(400.dp)
                        .height(300.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CreateImageProfile()
                    Divider()
                }
            }

        }

    }
}

@Composable
fun CreateImageProfile(modifier: Modifier = Modifier.size(140.dp)) {
    Surface(
        modifier = Modifier
            .size(180.dp)
            .padding(15.dp),
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyJetpackComposeStudiesAppTheme {
        BusinessCard()
    }
}