@file:OptIn(ExperimentalMaterial3Api::class)

package com.asoft.bazar.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.asoft.bazar.ui.components.button.BazarButton

@Composable
fun HomeScreen() {
    Scaffold(topBar = {
        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(), title = {
            Text("Top app bar")
        })
    }, bottomBar = {
        BottomAppBar {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Bottom app bar"
            )
        }
    }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = " This is content", modifier = Modifier.padding(8.dp)
            )

            BazarButton(
                text = "This is button",
                onClick = {},
                colors = ButtonDefaults.buttonColors()
            )
        }
    }
}