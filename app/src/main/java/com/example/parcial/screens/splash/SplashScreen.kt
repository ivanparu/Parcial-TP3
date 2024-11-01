package com.example.parcial.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcial.ui.theme.Green800
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcial.R
import kotlinx.coroutines.delay

//@Preview
@Composable
fun SplashScreen(navController: NavHostController) {
//fun SplashScreen() {
    Box(
        modifier = Modifier
            .background(Green800)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.group_1),
            contentDescription = "Splash Icon",
            modifier = Modifier.size(width = 257.dp, height = 36.dp)
        )

        LaunchedEffect(Unit) {
            delay(1800) //1.8 s
            navController.navigate("home"){
                popUpTo("splash") { inclusive = true }
            }
        }
    }
}