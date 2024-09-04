package com.progmobile.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.progmobile.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
               GreetingImage(message = stringResource(R.string.happy_birthday_text),
                            from = stringResource(R.string.signature_text),
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxSize()
               )

            }
        }
    }
}


@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier){
    val gradientColors = listOf(Color.Black, Color.Red)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 50.sp,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = gradientColors
                ),
                shadow = Shadow(Color.Black, Offset(3.0f, 5.0f), 5F)
            ),
            lineHeight = 60.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 34.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}


@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier)
{
    val image = painterResource(id = R.drawable.cayenne)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = "Photo de Queen Cayenne, une chatte grise très mignonne avec le" +
                    stringResource(R.string.cayenne_img_description),
            contentScale = ContentScale.Crop,
            alpha = 0.7F       )
        GreetingText(message = "Happy Birthday Lydie!",
            from = "From Némo",
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(message = "Happy Birthday Lydie!", from = "From Némo")
    }
}