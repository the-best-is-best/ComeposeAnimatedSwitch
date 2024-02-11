package io.github.tcomposeanimatedswitch

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedSwitch(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    iconChecked: @Composable () -> Unit,
    iconUnchecked: @Composable () -> Unit
) {
    val offsetValue = animateFloatAsState(if (isChecked) 30f else 20f, label = "moveSwitch")

    val rotation by animateFloatAsState(
        targetValue = if (isChecked) 360f else 0f,
        label = "rotation"
    )

    Box(
        modifier = modifier.size(100.dp , 30.dp) // Adjust size as needed

            .rotate(rotation) // Rotate based on animated value
            .clickable { onCheckedChange(!isChecked) }
    ) {
        Box(
            modifier = Modifier

                .offset(x = if(isChecked) offsetValue.value.dp *2 else offsetValue.value.dp *2-30.dp) // Adjust animation distance
                .rotate(rotation) // Rotate based on animated value



        ) {
//        Image(
//            modifier = Modifier
//                .padding(start = 8.dp),
//            painter = ,
//            contentDescription = null // Set appropriate description if needed
//        )
            if (isChecked) {
                iconChecked()
            } else {
                iconUnchecked()
            }
        }
    }
}