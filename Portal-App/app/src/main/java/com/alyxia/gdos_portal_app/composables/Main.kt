package com.alyxia.gdos_portal_app.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alyxia.gdos_portal_app.ui.theme.GildeDarkBlue
import com.alyxia.gdos_portal_app.ui.theme.GildeGrey
import com.alyxia.gdos_portal_app.ui.theme.GildePink

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Main(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(
                        modifier = Modifier.wrapContentHeight().fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Dashboard")
                    }
                },
                backgroundColor = Color(0xFF002F5D)
            )
        },
        content = {
            Column {
                Image(
                    painter = painterResource(id = com.alyxia.gdos_portal_app.R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.padding(40.dp)
                )
                LazyVerticalGrid(
                    cells = GridCells.Fixed(4),
                    content = {
                        item {
                            IconCard(
                                drawable = com.alyxia.gdos_portal_app.R.drawable.clock,
                                desc = "Clock",
                                bgColor = GildeGrey,
                                onClick = {
                                    navController.navigate("clockmanager")
                                }
                            )
                        }
                        item {
                            IconCard(
                                drawable = com.alyxia.gdos_portal_app.R.drawable.calendar,
                                desc = "Calendar",
                                bgColor = GildeDarkBlue
                            )
                        }
                        item {
                            IconCard(
                                drawable = com.alyxia.gdos_portal_app.R.drawable.note_text,
                                desc = "Notes",
                                bgColor = GildeDarkBlue,
                                onClick = {
                                    navController.navigate("todo")
                                }
                            )
                        }
                        item {
                            IconCard(
                                drawable = com.alyxia.gdos_portal_app.R.drawable.bell,
                                desc = "Notifications",
                                bgColor = GildePink
                            )
                        }
                    }
                )
            }
        }
    )
}

@ExperimentalMaterialApi
@Composable
fun IconCard(drawable: Int, desc: String, bgColor: Color, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .height(80.dp)
            .fillMaxWidth(),
        backgroundColor = bgColor,
        onClick = onClick
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = desc,
            contentScale = ContentScale.FillHeight
        )
    }
}
