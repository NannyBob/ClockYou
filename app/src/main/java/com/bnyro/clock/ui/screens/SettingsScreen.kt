package com.bnyro.clock.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bnyro.clock.R
import com.bnyro.clock.ui.model.SettingsModel
import com.bnyro.clock.ui.prefs.ButtonGroupPref
import com.bnyro.clock.ui.prefs.CheckboxPref
import com.bnyro.clock.ui.prefs.SettingsCategory
import com.bnyro.clock.util.Preferences

@Composable
fun SettingsScreen(
    settingsModel: SettingsModel
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 5.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        SettingsCategory(stringResource(R.string.appearance))
        ButtonGroupPref(
            preferenceKey = Preferences.themeKey,
            title = stringResource(R.string.theme),
            options = listOf(R.string.system, R.string.light, R.string.dark).map {
                stringResource(it)
            },
            values = listOf("system", "light", "dark"),
            defaultValue = "system"
        ) {
            settingsModel.themeMode = it
        }
        CheckboxPref(
            prefKey = Preferences.showSecondsKey,
            title = stringResource(R.string.show_seconds),
            defaultValue = true
        )
    }
}
