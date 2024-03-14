@file:OptIn(ExperimentalMaterial3Api::class)

package mindtech.homework.pokemonassignment.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TopNavigationBar(
    openDrawer: () -> Unit) {
    TopAppBar(
        title = {
            Text("Pokemon")
        },
        navigationIcon = {
            Icon(
                Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier.clickable {
                    openDrawer()
                }
            )
        },
        colors = TopAppBarColors(
            containerColor = Color.Red,
            actionIconContentColor = Color.Black,
            navigationIconContentColor = Color.Black,
            scrolledContainerColor = Color.Red,
            titleContentColor = Color.Black
        )
    )
}
