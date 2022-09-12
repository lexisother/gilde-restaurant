package dev.alyxia.portal_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beust.klaxon.Klaxon
import dev.alyxia.portal_app.structures.Health
import dev.alyxia.portal_app.ui.theme.PortalAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * @author X1nto
 */
class EpicViewModel : ViewModel() {
    private val client = OkHttpClient()
    var result by mutableStateOf<Health?>(null)
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val builtReq =
                    Request.Builder().url("https://gdos.alyxia.dev/api/health").build()
                val request = client.newCall(builtReq).execute()?.body()?.string()
                if (request != null) {
                    result = with(Klaxon()) {
                        parse<Health>(request)
                    }
                }
            } catch (e: Exception) {
                result = Health(ok = false)
            }
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
                    val apiHealth = viewModel.result
                    println("API is ok: $apiHealth")
                    if (apiHealth != null) {
                        Greeting(apiHealth.ok.toString())
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}