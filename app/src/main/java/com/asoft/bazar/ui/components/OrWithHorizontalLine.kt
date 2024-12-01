package com.asoft.bazar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.asoft.bazar.ui.theme.tokens.MyFontSize

@Composable
fun OrWithHorizontalLine(modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .width(158.dp)
                .height(1.dp)
                .background(
                    color = Color(0xFFE8E8E8),
                )
        ) {}
        Text(
            "Or with",
            color = Color(0xFFA5A5A5),
            fontSize = MyFontSize.body_medium,
        )
        Column(
            modifier = Modifier
                .width(158.dp)
                .height(1.dp)
                .background(
                    color = Color(0xFFE8E8E8),
                )
        ) {}
    }
}