package com.asoft.bazar.features.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asoft.bazar.R
import com.asoft.bazar.ui.components.button.PrimaryButton
import com.asoft.bazar.ui.components.text.HeaderText
import com.asoft.bazar.ui.components.textfield.BazarTextField
import com.asoft.bazar.ui.theme.BazarTheme

@Composable
fun SignUpScreen() {
    val scrollableState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
            .verticalScroll(state = scrollableState)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                BazarTheme.spacing.medium,
                Alignment.CenterVertically
            ),
        ) {
            HeaderText(
                text = stringResource(R.string.sign_up),
                modifier = Modifier
                    .padding(vertical = BazarTheme.spacing.medium)
                    .align(alignment = Alignment.Start)
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.choose_favorite_menu),
                style = BazarTheme.typography.bodyLarge,
                color = Color(0xFFA5A5A5)
            )
            Spacer(modifier = Modifier.padding(BazarTheme.spacing.medium))

            BazarTextField(
                value = "",
                onValueChange = {},
                labelText = stringResource(R.string.name),
                placeHolderResourceId = R.string.name_placeholder
            )
            BazarTextField(
                value = "",
                onValueChange = {},
                labelText = stringResource(R.string.email),
                placeHolderResourceId = R.string.email_placeholder
            )
            BazarTextField(
                value = "",
                onValueChange = {},
                labelText = stringResource(R.string.password),
                placeHolderResourceId = R.string.password_placeholder,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                iconResourceId = R.drawable.ic_ography_password_outline
            )
            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.register),
                onClick = {})

            SignUpTextLink(onClick = { })
        }

        Spacer(modifier = Modifier.weight(1f))

        TermOfServiceLink(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 16.dp),
            onClick = { })
    }
}

@Preview
@Composable
fun PrevSignUpScreen() {
    BazarTheme {
        SignUpScreen()
    }
}