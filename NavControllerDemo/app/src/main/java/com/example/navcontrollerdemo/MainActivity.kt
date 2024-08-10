package com.example.navcontrollerdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navcontrollerdemo.ui.theme.NavControllerDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavControllerDemoTheme {
                val navController = rememberNavController()  // 创建 NavController
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,   // 设置 NavController
                        startDestination = "first_screen",  // 设置起始目的地
                        modifier = Modifier.padding(innerPadding)  // 添加内边距
                    ) {
                        composable("first_screen") { FirstScreen(navController) }
                        composable("second_screen") { SecondScreen() }
                    }
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: androidx.navigation.NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "First Screen")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("second_screen")
        }) {
            Text(text = "Go to Second Screen")
        }
    }
}

@Composable
fun SecondScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Second Screen")
    }
}