package com.example.purecodelayoutdemo

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.purecodelayoutdemo.ui.theme.PureCodeLayoutDemoTheme

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            PureCodeLayoutDemoTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}


import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 创建一个LinearLayout作为根布局
        val linearLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        // 创建一个TextView
        val textView = TextView(this).apply {
            text = "Hello, World!"
            textSize = 24f
        }

        // 创建一个Button
        val button = Button(this).apply {
            text = "Click Me"
            setOnClickListener {
                textView.text = "Button Clicked!"
            }
        }

        // 将TextView和Button添加到LinearLayout
        linearLayout.addView(textView)
        linearLayout.addView(button)

        // 设置LinearLayout为Activity的内容视图
        setContentView(linearLayout)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PureCodeLayoutDemoTheme {
        Greeting("Android")
    }
}