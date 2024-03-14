package mindtech.homework.pokemonassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import mindtech.homework.pokemonassignment.ui.navigation.Navigation
import mindtech.homework.pokemonassignment.ui.navigation.TopNavigationBar
import mindtech.homework.pokemonassignment.ui.screen.PokemonListScreen
import mindtech.homework.pokemonassignment.ui.theme.PokemonAssignmentTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PokemonAssignmentTheme {
                val scope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val navController = rememberNavController()

                Scaffold(
                    topBar = {
                        TopNavigationBar(
                            openDrawer = {
                                scope.launch {
                                    drawerState.apply {
                                        open()
                                    }
                                }
                            }
                        )
                    }
                ) {
                    Surface(
                        modifier = Modifier.padding(it)
                    ){
                        Navigation(
                            navController = navController
                        )
                    }
                }
            }
        }

    }
}