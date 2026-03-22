package net.thechance.caffine.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import net.thechance.caffine.style.Colors

@Composable
fun CoffeeButton(
    caption: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: Painter? = null,
){
    Button(
        shape = RoundedCornerShape(100),
        onClick = onClick,
        modifier = modifier.height(56.dp)
            .dropShadow(
                shape = RoundedCornerShape(100),
                shadow = Shadow(
                    radius = 12.dp,
                    spread = 0.dp,
                    color = Colors.buttonShadow,
                    offset = DpOffset(x = 0.dp, 6.dp)
                )
            ),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = Colors.buttonColor
        ),
        contentPadding = PaddingValues(horizontal = 32.dp)
    ) {
        Text(
            text = caption,
            modifier = Modifier.padding(end = 8.dp)
        )
        icon?.let {
            Icon(
                painter = icon,
                contentDescription = null
            )
        }
    }
}