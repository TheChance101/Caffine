package net.thechance.caffine.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.thechance.caffine.style.Colors
import net.thechance.caffine.style.sizePickerTitles

@Composable
fun SizePicker(
    options: List<String>,
    selectedIndex: Int,
    onChangesSelectedOption: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    SliderBar(modifier) {
        Bubble(
            modifier = modifier.padding(8.dp)
                .graphicsLayer{
                    translationX = (48 * selectedIndex).dp.toPx()
                }
        )
        Row(
            modifier = modifier.fillMaxHeight().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            options.forEachIndexed { index, option ->
                SingleOptionItem(
                    title = option,
                    isSelected = index == selectedIndex,
                    modifier = Modifier.clip(CircleShape)
                        .clickable { onChangesSelectedOption(index) }
                )
            }

        }
    }
}


@Composable
private fun SingleOptionItem(
    title: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier
){
    val textColor = if (isSelected) Colors.onBubble else Colors.text
    Box(
        modifier = modifier.size(40.dp),
        contentAlignment = Alignment.Center
    ) {
        BasicText(
            text = title,
            style = sizePickerTitles.copy(color = textColor)
        )
    }

}

@Preview
@Composable
private fun SizePickerPreview() {
    var selectedOptionIndex: Int by remember { mutableIntStateOf(0) }
    SizePicker(
        options = listOf("S", "M", "L", "XL"),
        selectedIndex = selectedOptionIndex,
        onChangesSelectedOption = { selectedOptionIndex = it}
    )
}