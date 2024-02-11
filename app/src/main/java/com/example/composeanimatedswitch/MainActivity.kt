package com.example.composeanimatedswitch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.TextFields
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeanimatedswitch.ui.theme.ComposeAnimatedSwitchTheme
import io.github.tcomposeanimatedswitch.AnimatedSwitch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimatedSwitchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var selectImageSelected by remember {
        mutableStateOf(false)
    }
    AnimatedSwitch(
        modifier = Modifier .clip(RoundedCornerShape(20.dp)), // Adjust corner radius as needed,
        isChecked = selectImageSelected,
        onCheckedChange = {
            selectImageSelected = it
        },
        iconChecked = {
            Icon(
                Icons.Outlined.Image,
                modifier = Modifier.size(20.dp, 30.dp),
                contentDescription = null,
                tint = Color.White
            )
        },
        iconUnchecked = {
            Icon(
                Icons.Outlined.TextFields,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(20.dp, 30.dp),

                )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeAnimatedSwitchTheme {
        Greeting("Android")
    }
}