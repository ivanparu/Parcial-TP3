package com.example.parcial.screens.profile

import com.example.parcial.model.model.user.UserViewModelFactory
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcial.R
import com.example.parcial.shared.infraestructure.RetrofitModule
import com.example.parcial.shared.infraestructure.users.UserRepository
import com.example.parcial.ui.components.GridBotonesClickProfile
import com.example.parcial.ui.theme.BackgroundScreens
import com.example.parcial.ui.theme.DarkPurple
import com.example.parcial.model.model.user.UserViewModel
import kotlinx.coroutines.delay

@Composable
fun ProfileScreen(onCloseProfile: () -> Unit
) {
    val userRepository = UserRepository(RetrofitModule.userServices)
    val factory = UserViewModelFactory(userRepository)
    val userViewModel: UserViewModel = viewModel(factory = factory)

    val userName by userViewModel.userName.collectAsState()
    var isVisible by remember { mutableStateOf(false) }
    var isExiting by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        userViewModel.fetchUser(2)
        delay(200)
        isVisible = true
    }

    BackHandler(enabled = true) {
        isExiting = true
    }

    AnimatedVisibility(
        visible = isVisible && !isExiting,
        enter = slideInHorizontally(
            initialOffsetX = { -it },
            animationSpec = tween(durationMillis = 200)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { it },
            animationSpec = tween(durationMillis = 200)
        )
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundScreens)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                Text(
                    text = "Mi Perfil",
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 22.sp,
                    color = DarkPurple,
                    modifier = Modifier.padding(bottom = 22.dp)
                )
            }
            item {
                Icon(
                    painter = painterResource(id = R.drawable.profile_img),
                    tint = Color.Unspecified,
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(140.dp)
                        .background(Color.Gray, shape = CircleShape)
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                Text(
                    text = if (userName != null) "\uD83D\uDC4B Hola $userName" else "Loading...",
                    style = MaterialTheme.typography.titleSmall,
                    color = DarkPurple,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item {
                GridBotonesClickProfile()
            }
        }
    }
    LaunchedEffect(isExiting) {
        if (isExiting) {
            delay(100)
            onCloseProfile()
        }
    }
}
