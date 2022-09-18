package dev.alyxia.portal_app.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import dev.alyxia.portal_app.lib.HttpViewModel
import dev.alyxia.portal_app.rest.body.ProductBody
import dev.alyxia.portal_app.rest.dto.ApiProduct
import dev.alyxia.portal_app.rest.dto.ApiResponse
import dev.alyxia.portal_app.rest.dto.ProductList
import dev.alyxia.portal_app.rest.service.APIProductServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MenuViewModel : HttpViewModel<ProductList>() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            result = APIProductServiceImpl(client).fetchAll()
        }
    }

    fun fetch(name: String) {
        viewModelScope.launch {
            result = APIProductServiceImpl(client).fetch(
                ProductBody(name)
            )
        }
    }
}

@Composable
fun MenuCard(navController: NavController, viewModel: MenuViewModel = viewModel()) {
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
            var res: List<ApiProduct>? = null
            var err: String? = null
            when (val result = viewModel.result) {
                is ApiResponse.Success -> res = result.data
                is ApiResponse.Error -> {
                    err = result.error.error.type
                    res = null
                }
                else -> false
            }

            LazyVerticalGrid(
                modifier = Modifier.padding(8.dp),
                columns = GridCells.Fixed(4)
            ) {
                res?.let { products ->
                    items(products) { product ->
                        ListItem(product)
                    }
                }
            }
        }
    }
}

@Composable
fun ListItem(product: ApiProduct) {
    var isDialogVisible by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isDialogVisible = true },
        elevation = 10.dp
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Text(product.name)
            Text(product.description)
        }
    }
}