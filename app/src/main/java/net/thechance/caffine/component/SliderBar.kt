package net.thechance.caffine.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import net.thechance.caffine.style.Colors

@Composable
fun SliderBar(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier.height(56.dp)
            .clip(RoundedCornerShape(100))
            .background(Colors.surface),
        contentAlignment = Alignment.CenterStart
    ) {
        content()
    }
}