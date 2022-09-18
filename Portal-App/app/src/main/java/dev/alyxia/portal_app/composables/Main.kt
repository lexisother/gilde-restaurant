package dev.alyxia.portal_app.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import dev.alyxia.portal_app.rest.dto.ApiHealth
import dev.alyxia.portal_app.rest.dto.ApiResponse
import dev.alyxia.portal_app.rest.service.APIHealthServiceImpl
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

/**
 * @author X1nto
 */
class MainViewModel : ViewModel() {
    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    var result by mutableStateOf<ApiResponse<ApiHealth>?>(null)
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            result = APIHealthServiceImpl(client).checkHealth()
        }
    }
}

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun Main(
    navController: NavController,
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val scaffoldState = rememberScaffoldState()

    Surface(modifier = Modifier.fillMaxSize()) {
        if (viewModel.result == null) {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Loading..."
                )
            }
        } else {
            val res: Boolean?
            var err: String? = null
            when (val result = viewModel.result) {
                is ApiResponse.Success -> res = result.data.ok
                is ApiResponse.Error -> {
                    err = result.error.error.type
                    res = false
                }
                else -> res = false
            }

            Column {
                Text(text = "API is ok: $res")
                Button(onClick = { navController.navigate("menu") }) {

                }
                if (err !== null) {
                    var isDialogVisible by remember { mutableStateOf(false) }
                    LaunchedEffect(scaffoldState.snackbarHostState) {
                        val res =
                            scaffoldState.snackbarHostState.showSnackbar(
                                message = "E",
                                actionLabel = "E"
                            )

                        when (res) {
                            SnackbarResult.ActionPerformed -> {
                                // TODO: Show modal
                            }
                            SnackbarResult.Dismissed -> {}
                        }
                    }
                }
            }
        }
    }
}
