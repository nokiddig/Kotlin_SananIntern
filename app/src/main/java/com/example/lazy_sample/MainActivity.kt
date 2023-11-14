package com.example.lazy_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lazy_sample.ui.theme.Lazy_sampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lazy_sampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MyNavigationDemo()
                }
            }
        }
    }
}

@Composable
fun MyNavigationDemo() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeScreen" ){
        composable("HomeScreen") { MyNavigationDemo()}
        composable("FirstScreen") { ImageCompDemo(navController)}
        composable("SecondScreen") { LazyDemo(navController) }
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = { navController.navigate("FirstScreen") }) {
            Text(text = "First screen")
        }
        Button(onClick = { navController.navigate("SecondScreen")}) {
            Text(text = "Lazy column")
        }
    }
}

@Preview (showSystemUi = true,
    showBackground = true)
@Composable
fun AppPreview() {
    MyNavigationDemo()
}