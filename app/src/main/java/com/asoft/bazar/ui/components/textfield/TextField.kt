package com.asoft.bazar.ui.components.textfield

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asoft.bazar.R
import com.asoft.bazar.ui.components.icon.BazarIcon
import com.asoft.bazar.ui.theme.BazarTheme


@Composable
fun BazarTextField(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes placeHolderResourceId: Int,
    @DrawableRes iconResourceId: Int? = null,
    modifier: Modifier = Modifier,
    placeholder: @Composable (() -> Unit) = {
        Text(
            text = stringResource(id = placeHolderResourceId),
            color = BazarTheme.colors.outlineVariant
        )
    },
    labelText: String,
    trailingIcon: @Composable (() -> Unit) = {
        iconResourceId?.let {
            BazarIcon(
                iconResourceId = it,
                contentDescription = stringResource(id = placeHolderResourceId)
            )
        }

    },
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(text = labelText, style = BazarTheme.typography.bodyMedium)
        OutlinedTextField(
            modifier = modifier.background(BazarTheme.colors.background),
            value = value,
            onValueChange = onValueChange,
            trailingIcon = trailingIcon,
            placeholder = placeholder,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation,
            shape = BazarTheme.shapes.medium,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Gray,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedPlaceholderColor = Color.Gray
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrevTextField() {
    BazarTextField(
        value = "",
        onValueChange = {},
        labelText = "Email",
        placeHolderResourceId = R.string.email_placeholder,
        iconResourceId = R.drawable.ic_ography_password_outline
    )
}

@Preview(showBackground = true)
@Composable
fun PrevTextFieldTrailingIcon() {
    BazarTextField(
        value = "",
        onValueChange = {},
        labelText = "Password",
        placeHolderResourceId = R.string.email_placeholder,
        iconResourceId = R.drawable.ic_ography_password_outline
    )
}