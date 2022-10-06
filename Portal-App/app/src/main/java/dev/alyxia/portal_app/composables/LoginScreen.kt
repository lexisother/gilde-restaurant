package dev.alyxia.portal_app.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import dev.alyxia.portal_app.lib.HttpViewModel
import dev.alyxia.portal_app.rest.body.UserAuthBody
import dev.alyxia.portal_app.rest.dto.ApiResponse
import dev.alyxia.portal_app.rest.dto.ApiUser
import dev.alyxia.portal_app.rest.service.APIUserServiceImpl
import kotlinx.coroutines.launch

class LoginViewModel : HttpViewModel<ApiUser>() {
    fun login(email: String, password: String) {
        viewModelScope.launch {
            result = APIUserServiceImpl(client).login(
                UserAuthBody(email, password)
            )
        }
    }
}

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = viewModel()) {
    val scaffoldState = rememberScaffoldState()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Column {
            Text(
                modifier = Modifier
                    .padding(top = 120.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 25.sp,
                text = "Login to"
            )
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 25.sp,
                text = "Holly Guacamoley"
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 160.dp)
                .wrapContentHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            var emailState by remember { mutableStateOf(TextFieldValue()) }
            var passState by remember { mutableStateOf(TextFieldValue()) }
            var passwordVisibility by remember { mutableStateOf(false) }
            var isErrorred by remember { mutableStateOf(false) }
            val pattern = "^[^@]+@[^@]+\\.[^@]+\$".toRegex()


            TextField(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                label = { Text("Email") },
                value = emailState,
                isError = isErrorred,
                onValueChange = {
                    emailState = it
                    isErrorred = !emailState.text.contains(pattern)
                }
            )
            AnimatedVisibility(visible = isErrorred) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        fontSize = 10.sp,
                        color = MaterialTheme.colors.error,
                        text = "Invalid email!"
                    )
                }
            }
            TextField(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                label = { Text("Password") },
                value = passState,
                onValueChange = { passState = it },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image =
                        if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(imageVector = image, "Show/Hide password")
                    }
                }
            )
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp),
//                colors = ButtonDefaults.buttonColors(backgroundColor = )
                onClick = {
                    if (emailState.text.isNotEmpty() && !isErrorred && passState.text.isNotEmpty()) {
                        viewModel.login(emailState.text, passState.text)
                        when (val result = viewModel.result) {
                            is ApiResponse.Success -> navController.navigate("main")
                            is ApiResponse.Error -> {
                                TODO("Handle the error")
                            }
                            else -> {}
                        }
                        navController.navigate("main")
                    }
                }
            ) {
                Text("Login")
            }
        }
    }
}