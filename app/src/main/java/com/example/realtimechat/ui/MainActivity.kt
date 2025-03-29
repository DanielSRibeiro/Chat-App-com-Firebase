package com.example.realtimechat.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.realtimechat.ui.screen.MainScreen
import com.example.realtimechat.ui.theme.RealtimeChatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!requestPermissions()) {
            ActivityCompat.requestPermissions(
                this,
                PERMISSIONS.toTypedArray(),
                0
            )
        }

        setContent {
            RealtimeChatTheme {
                MainScreen()
            }
        }
    }


    private fun requestPermissions(): Boolean {
        return PERMISSIONS.all { permission ->
            ContextCompat.checkSelfPermission(
                applicationContext,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        }
    }


    companion object {
        private val PERMISSIONS = listOf(
            Manifest.permission.POST_NOTIFICATIONS,
        )
    }
}