package com.example.realtimechat.ui.screen.sms_verification

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SMSVerificationScreen(
    modifier: Modifier = Modifier,
    verification: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Verificação de SMS", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = "Verificação de SMS", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.padding(48.dp))

        InputCode()

        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = {
                verification()
            }
        ) {
            Text(text = "Verificar")
        }

    }
}


@Composable
fun InputCode(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .weight(1f)
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .weight(1f)
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Preview
@Composable
private fun SMSVerificationPreview() {
    SMSVerificationScreen()
}