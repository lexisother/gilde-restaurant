package dev.alyxia.portal_app.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import dev.alyxia.portal_app.lib.HttpViewModel
import dev.alyxia.portal_app.rest.body.UserAuthBody
import dev.alyxia.portal_app.rest.dto.ApiUser
import dev.alyxia.portal_app.rest.service.APIUserServiceImpl
import kotlinx.coroutines.launch

class ClockViewModel : HttpViewModel<ApiUser>() {
    fun clock(email: String, password: String) {
        viewModelScope.launch {
            result = APIUserServiceImpl(client).clock(
                UserAuthBody(email, password)
            )
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ClockManager(navController: NavController, viewModel: ClockViewModel = viewModel()) {
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
                backgroundColor = Color(0xDC7A34FF)
            )
        },
        content = {
            var clockedIn by remember { mutableStateOf(false) }
            var clockInEnabled by remember { mutableStateOf(true) }
            var clockOutEnabled by remember { mutableStateOf(false) }
        }
    )
}