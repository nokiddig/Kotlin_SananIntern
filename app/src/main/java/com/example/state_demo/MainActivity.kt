@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.state_demo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.state_demo.ui.theme.State_demoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            State_demoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login("Android")
                }
            }
        }
    }
}

@Composable
fun Login(name: String, modifier: Modifier = Modifier) {
    Log.e("my_log", "start login")

    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        EmailInput(email = email) {
            email = it
        }
        PasswordInput(password = password){
            password = it
        }
    }
    Log.e("my_log", "end login")
}

@Composable
fun EmailInput(email:String, onEmailChange: (String) -> Unit) {
    Log.e("my_log", "onEmailChange")
    OutlinedTextField(value = email, onValueChange = onEmailChange)
}

@Composable
fun PasswordInput(password:String, onPasswordChange: (String) -> Unit) {
    Log.e("my_log", "onPass")
    OutlinedTextField(value = password, onValueChange = onPasswordChange)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    State_demoTheme {
        Login("Android")
    }
}