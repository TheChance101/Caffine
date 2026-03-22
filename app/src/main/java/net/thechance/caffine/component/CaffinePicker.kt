package net.thechance.caffine.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.thechance.caffine.R
import net.thechance.caffine.style.Colors
import net.thechance.caffine.style.caffinePickerAmount

@Composable
fun CaffinePicker(
    amount: Int,
    onChangeAmount: (Int) -> Unit,
    modifier: Modifier = Modifier,
){
    Column(modifier) {
        SliderBar {
            Bubble(
                modifier = Modifier.padding(8.dp)
                    .graphicsLayer{
                        translationX = (48 * amount).dp.toPx()
                    }
            ) {
                Icon(
                    painter = painterResource(R.drawable.coffee_beans),
                    tint = Colors.onBubble,
                    contentDescription = "2 Beans",
                    modifier = Modifier.size(24.dp).align(Alignment.Center)
                )
            }

            Row(
                modifier = Modifier.fillMaxHeight().padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                repeat(3){
                    Box(
                        modifier = Modifier.clip(CircleShape)
                            .size(40.dp)
                            .clickable { onChangeAmount(it) }
                    )
                }
            }
        }
        AmountCaptions()
    }
}

@Composable
private fun AmountCaptions(){
    Row(
        modifier = Modifier.width(152.dp).padding(top = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BasicText(
            text = "Low",
            style = caffinePickerAmount.copy(color = Colors.text)
        )
        BasicText(
            text = "Medium",
            style = caffinePickerAmount.copy(color = Colors.text)
        )
        BasicText(
            text = "High",
            style = caffinePickerAmount.copy(color = Colors.text)
        )
    }
}

@Preview
@Composable
private fun CaffinePickerPreview() {
    var selectedAmount: Int by remember { mutableIntStateOf(0) }

    CaffinePicker(
        amount = selectedAmount,
        onChangeAmount = { selectedAmount = it }
    )
}