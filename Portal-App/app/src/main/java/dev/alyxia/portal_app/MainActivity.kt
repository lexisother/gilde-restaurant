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
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import dev.alyxia.portal_app.structures.TodoDB
import dev.alyxia.portal_app.structures.TodoDBItem
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
    var result by mutableStateOf<TodoDB?>(null)
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val builtReq =
                Request.Builder().url("https://nova-vps.ml/~alyxia/api/todo.json").build()
            val request = client.newCall(builtReq).execute()?.body()?.string()
            if (request != null) {
                result = with(Klaxon()) {
                    parse<Map<String, JsonObject>>(request)?.mapValues {
                        parseFromJsonObject<TodoDBItem>(it.value)!!
                    }
                }
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
                    val items = viewModel.result
                    println(items)
                    items?.get("0")?.let { Greeting(it.name) }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}