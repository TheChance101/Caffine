package net.thechance.caffine.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import net.thechance.caffine.R

@Composable
fun Cup(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.cup),
            contentDescription = "Cup",
            modifier = Modifier.size(width = 200.dp, height = 244.dp)
        )
        Image(
            painter = painterResource(R.drawable.brand_logo),
            contentDescription = "Cup",
            modifier = Modifier.size(66.dp)
        )
    }
}