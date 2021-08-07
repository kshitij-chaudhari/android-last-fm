/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.ui.common.composables

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun Preview_HeaderText() {
    HeaderText(text = "Make Believe")
}

/**
 * Reusable header text used as title on list item.
 */
@Composable
fun HeaderText(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text, fontWeight = FontWeight.Bold,
        modifier = modifier,
        maxLines = 2, overflow = TextOverflow.Ellipsis,
        color = MaterialTheme.colors.primary
    )
}
