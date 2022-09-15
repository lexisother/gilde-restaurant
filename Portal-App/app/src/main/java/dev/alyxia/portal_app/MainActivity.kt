package dev.alyxia.portal_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.alyxia.portal_app.rest.dto.ApiHealth
import dev.alyxia.portal_app.rest.dto.ApiResponse
import dev.alyxia.portal_app.rest.service.APIHealthServiceImpl
import dev.alyxia.portal_app.ui.theme.PortalAppTheme
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
class EpicViewModel : ViewModel() {
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortalAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel: EpicViewModel by viewModels()

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
                            Text(modifier = Modifier.align(Alignment.CenterHorizontally), text = "Loading...")
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
                            if (err !== null) Text(text = err)
                        }
                    }
                }
            }
        }
    }
}
