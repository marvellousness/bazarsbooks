package com.asoft.bazar.features.signin

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asoft.bazar.R
import com.asoft.bazar.ui.components.BazarTopAppBar
import com.asoft.bazar.ui.components.OrWithHorizontalLine
import com.asoft.bazar.ui.components.button.BazarBackButton
import com.asoft.bazar.ui.components.button.PrimaryButton
import com.asoft.bazar.ui.components.button.SignInButton
import com.asoft.bazar.ui.components.button.TextButton
import com.asoft.bazar.ui.components.text.HeaderText
import com.asoft.bazar.ui.components.textfield.BazarTextField
import com.asoft.bazar.ui.theme.BazarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen() {
    val scrollableState = rememberScrollState()
    Scaffold(topBar = {
        BazarTopAppBar(
            title = {},
            navigationIcon = {
                BazarBackButton(onClick = { })
            })
    }) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(state = scrollableState)
                .fillMaxSize()
        ) {
            HeaderText(
                text = stringResource(R.string.welcome_header_text),
                modifier = Modifier
                    .padding(vertical = BazarTheme.spacing.medium)
                    .align(alignment = Alignment.Start)
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.sign_to_your_account),
                style = BazarTheme.typography.bodyLarge,
                color = Color(0xFFA5A5A5)
            )
            Spacer(modifier = Modifier.padding(BazarTheme.spacing.medium))
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    BazarTheme.spacing.medium,
                    Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.Start,
            ) {
                BazarTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    onValueChange = {},
                    labelText = stringResource(R.string.email),
                    placeHolderResourceId = R.string.email_placeholder
                )
                BazarTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    onValueChange = {},
                    labelText = stringResource(R.string.password),
                    placeHolderResourceId = R.string.password_placeholder,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    iconResourceId = R.drawable.ic_ography_password_outline
                )
                TextButton(
                    text = stringResource(R.string.forgot_password),
                    onClick = {}
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(
                    BazarTheme.spacing.medium,
                    Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.login),
                    onClick = {})

                SignInTextLink(onClick = { })
                OrWithHorizontalLine(modifier = Modifier.fillMaxWidth())
                SignInButton(
                    text = stringResource(R.string.sign_in_with_google),
                    painter = painterResource(id = R.drawable.ic_google_original),
                    onClick = {}
                )
                SignInButton(
                    text = stringResource(R.string.sign_in_with_apple),
                    painter = painterResource(id = R.drawable.ic_apple_original),
                    onClick = {}
                )
            }
        }
    }
}

@Preview
@Composable
fun PrevSignInScreen() {
    SignInScreen()
} 