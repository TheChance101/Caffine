package net.thechance.caffine.screen.amount

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
            BasicText(
                text = "${state.cupSizeInMl} ML",
                style = amountText.copy(color = Colors.text),
                modifier = Modifier.padding(top = 64.dp, start = 16.dp)
            )
            Cup(Modifier.align(Alignment.Center))
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

        Button(
            shape = RoundedCornerShape(100),
            onClick = interactions::onClickContinue,
            modifier = Modifier.padding(top = 92.dp)
                .height(56.dp)
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
                text = "Continue",
                modifier = Modifier.padding(end = 8.dp)
            )
            Icon(
                painter = painterResource(R.drawable.arrow_next),
                contentDescription = "next arrow icon"
            )
        }
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