package net.thechance.caffine.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import net.thechance.caffine.R
import net.thechance.caffine.style.Colors
import net.thechance.caffine.style.appBarTitle

@Composable
fun AppBar(
    title: String,
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier.size(48.dp)
                .clip(CircleShape)
                .clickable{ onClickBack() }
                .background(Colors.surface),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_back),
                contentDescription = "back arrow",
                modifier = Modifier.size(24.dp),
                tint = Colors.titles
            )
        }
        BasicText(
            text = title,
            style = appBarTitle.copy(
                color = Colors.titles
            )
        )
    }
}
