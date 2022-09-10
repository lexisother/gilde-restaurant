package com.alyxia.gdos_portal_app.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ClockManager() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Clock Manager")
                    }
                },
                backgroundColor = Color(0xFF002F5D)
            )
        },
        content = {
            var clockedIn by remember { mutableStateOf(false) }
            var clockInEnabled by remember { mutableStateOf(true) }
            var clockOutEnabled by remember { mutableStateOf(false) }

            Column {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        modifier = Modifier.padding(top = 120.dp, bottom = 20.dp),
                        fontSize = 25.sp,
                        text = if (clockedIn) "Clocked in" else "Clocked out"
                    )

                    Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                        Spacer(modifier = Modifier.weight(1f))
                        Button(
                            enabled = clockInEnabled,
                            onClick = {
                                clockedIn = !clockedIn
                                clockInEnabled = !clockInEnabled
                                clockOutEnabled = !clockOutEnabled
                            }
                        ) {
                            Text("Clock In")
                        }
                        Button(
                            enabled = clockOutEnabled,
                            onClick = {
                                clockedIn = !clockedIn
                                clockInEnabled = !clockInEnabled
                                clockOutEnabled = !clockOutEnabled
                            }
                        ) {
                            Text("Clock Out")
                        }
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    )
}
