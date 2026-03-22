package net.thechance.caffine.screen.amount

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import net.thechance.caffine.R
import net.thechance.caffine.component.AppBar
import net.thechance.caffine.component.CaffinePicker
import net.thechance.caffine.component.CoffeeButton
import net.thechance.caffine.style.Colors
import net.thechance.caffine.component.Cup
import net.thechance.caffine.component.SizePicker
import net.thechance.caffine.style.amountText

@Composable
fun CoffeeAmountScreen(
    viewModel: CoffeeAmountViewModel = viewModel()
) {
    val screenState : CoffeeAmountScreenState by viewModel.state.collectAsStateWithLifecycle()

    CoffeeAmountContent(
        state = screenState,
        interactions = viewModel,
    )
}

@Composable
private fun CoffeeAmountContent(
    state: CoffeeAmountScreenState,
    interactions: CoffeeAmountInteractions,
) {
    val cupScale by animateFloatAsState(
        targetValue = when(state.cupSizeIndex) {
            0 -> 0.77f
            2 -> 1.23f
            else -> 1f
        },
        animationSpec = tween(600)
    )
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBar(
            title = "Macchiato",
            onClickBack = {}
        )
        Box(
            modifier = Modifier.fillMaxWidth()
                .height(340.dp)
        ) {
            AnimatedContent(
                targetState = state.cupSizeInMl,
                transitionSpec = {
                    (fadeIn(tween(600))
                        .togetherWith(fadeOut(tween(600))))
                }
            ) { cupSizeInMl ->
                BasicText(
                    text = "$cupSizeInMl ML",
                    style = amountText.copy(color = Colors.text),
                    modifier = Modifier.padding(top = 64.dp, start = 16.dp)
                )
            }

            Cup(
                modifier = Modifier.align(Alignment.Center)
                    .graphicsLayer {
                        scaleX = cupScale
                        scaleY = cupScale
                    }
            )
        }
        SizePicker(
            options = state.availableSizes,
            selectedIndex = state.cupSizeIndex,
            onChangesSelectedOption = interactions::onChangeCupSize
        )

        CaffinePicker(
            amount = state.caffineAmountIndex,
            onChangeAmount = interactions::onChangeCaffineAmount,
            modifier = Modifier.padding(top = 16.dp)
        )

        CoffeeButton(
            caption = "Continue",
            onClick = interactions::onClickContinue,
            icon = painterResource(R.drawable.arrow_next),
            modifier = Modifier.padding(top = 92.dp)
        )
    }
}

@Preview
@Composable
private fun CoffeeAmountScreenPreview(){
    CoffeeAmountContent(
        state = CoffeeAmountScreenState(),
        interactions = object : CoffeeAmountInteractions{
            override fun onClickContinue() {
                TODO("Not yet implemented")
            }

            override fun onChangeCupSize(newSize: Int) {
                TODO("Not yet implemented")
            }

            override fun onChangeCaffineAmount(newAmount: Int) {
                TODO("Not yet implemented")
            }
        }
    )
}