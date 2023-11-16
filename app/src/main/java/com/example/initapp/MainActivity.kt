package com.example.initapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.initapp.ui.theme.InitAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //LocalAppColor provides AppColor(textColor = Color.Black)
            CompositionLocalProvider(LocalAppColor.provides(AppColor(textColor = Color.Black))) {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun Header(title: String) {
    Log.e("my_log", "Header")
    Text(title, style = TextStyle(
        color = LocalAppColor.current.textColor,
        fontSize = 24.sp
    ))
}

@Composable
fun Body(content:String, bodyTextColor: Color) {
    Log.e("my_log", "Body")
    CompositionLocalProvider (LocalAppColor provides
            LocalAppColor.current.copy(textColor = bodyTextColor)){
        Column {
            Text(text = content,
                style = TextStyle(color = LocalAppColor.current.textColor))
            Spacer(modifier = Modifier.height(12.dp))
            ImageFeature()
        }
    }
}

@Composable
fun ImageFeature() {
    Log.e("my_log", "Image feature")
    Row {
        Icon(imageVector = Icons.Outlined.Person, contentDescription = null)
        Spacer(modifier = Modifier.width(12.dp))
        Icon(imageVector = Icons.Outlined.Person, contentDescription = null)
        Spacer(modifier = Modifier.width(12.dp))
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Log.e("my_log", "MainScreen")

    var bodyTextColor by remember {
        mutableStateOf(Color.Black)
    }
    Column {
        Header(title = "Composition Local")
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "composition local", color = LocalAppColor.current.textColor)
        Spacer(modifier = Modifier.height(12.dp))
        Body(content = "Content", bodyTextColor = bodyTextColor)
        Button(onClick = {
            bodyTextColor = GetColor()
        }) {
            Text(text = "Change text color")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InitAppTheme {
        MainScreen()
    }
}

data class AppColor(val textColor: Color = Color.Black)

val LocalAppColor = staticCompositionLocalOf { AppColor(textColor = Color.Black) }
fun GetColor(): Color{
    val listColors = listOf(Color.Blue, Color.Red, Color.Green, Color.Cyan)
    val index = Random.nextInt(0, 4)
    return listColors[index]
}