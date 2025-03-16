package com.example.clean_architecture_android.core.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun EmptyMessage(
    message: String,
    fontSize: Int = 20,
    fontWeight: FontWeight = FontWeight.Bold,
    color: Color = Color.Gray
) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            fontSize = fontSize.sp,
            fontWeight = fontWeight,
            color = color
        )
    }
}