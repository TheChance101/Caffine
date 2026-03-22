package net.thechance.caffine.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import net.thechance.caffine.style.Colors

@Composable
fun Bubble(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit = {}
){
    Box(
        modifier = modifier.size(40.dp)
            .dropShadow(
                shape = CircleShape,
                shadow = Shadow(
                    radius = 16.dp,
                    spread = 0.dp,
                    color = Colors.bubbleShadow,
                    offset = DpOffset(x = 0.dp, 6.dp)
                )


            )
            .clip(CircleShape)
            .background(Colors.bubble),
        content = content
    )
}
