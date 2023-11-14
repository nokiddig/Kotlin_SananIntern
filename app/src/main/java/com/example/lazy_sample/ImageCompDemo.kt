package com.example.lazy_sample

import androidx.compose.foundation.Image
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun ImageCompDemo(navController: NavController) {
    Surface {
        Image(painter = painterResource(id = R.drawable.background_image), contentDescription = "null")
    }
}