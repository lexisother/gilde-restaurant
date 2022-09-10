package com.alyxia.gdos_portal_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.alyxia.gdos_portal_app.R.drawable.*
import com.alyxia.gdos_portal_app.structures.TodoDB
import com.alyxia.gdos_portal_app.structures.TodoDBItem
import com.alyxia.gdos_portal_app.ui.theme.Shapes

@ExperimentalComposeUiApi
@Composable
fun Todo(navController: NavController, todoItems: TodoDB?) {
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
                        Text("Todo")
                    }
                },
                backgroundColor = Color(0xFF002F5D)
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                todoItems?.let { items ->
                    if (items.isEmpty()) {
                        item {
                            Column(
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Nobody here but us chickens.")
                            }
                        }
                    } else {
                        items(items.values.sortedByDescending { it.priority ?: 0 }) { item ->
                            TodoItem(item = item, meta = {
                                when (item.priority) {
                                    null -> MetaItem("Priority", tbd_priority)
                                    1 -> MetaItem("Priority", low_priority)
                                    2 -> MetaItem("Priority", mid_priority)
                                    3 -> MetaItem("Priority", high_priority)
                                }
                            })
                        }
                    }
                }
            }
        }
    )
}

@ExperimentalComposeUiApi
@Composable
fun TodoItem(item: TodoDBItem, meta: @Composable () -> Unit = {}) {
    var isDialogVisible by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isDialogVisible = true },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                fontSize = 30.sp,
                text = item.name
            )
            Row(
                modifier = Modifier.padding(10.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                meta()
            }
        }
    }

    // NOTE: Not sure if I should keep this.
    //    The only use there would be in a menu such as this, would be to manage the item
    //    through e.g. a cog icon on the card, which opens the dialog, presenting some buttons.
    if (isDialogVisible) {
        Dialog(
            onDismissRequest = { isDialogVisible = false },
            properties = DialogProperties(usePlatformDefaultWidth = false),
            content = {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp)
                        .background(Color(0xFF2d2d2d)),
                    elevation = 10.dp
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(
                            fontSize = 20.sp,
                            text = item.name
                        )
                        Text(item.content)
                    }
                }
            }
        )
    }
}

@Composable
fun MetaItem(text: String, drawable: Int = 0) {
    Card(
        backgroundColor = Color(0xFF3d3d3d)
    ) {
        Row(
            modifier = Modifier
                .background(Color(0xFF3d3d3d), Shapes.large)
                .padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Image(
                modifier = Modifier.padding(top = 4.dp),
                painter = painterResource(drawable),
                contentDescription = text,
                contentScale = ContentScale.FillHeight,
            )
            Text(text)
        }
    }
}
