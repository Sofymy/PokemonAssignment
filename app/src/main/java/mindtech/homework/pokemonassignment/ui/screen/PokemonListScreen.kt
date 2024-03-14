@file:OptIn(ExperimentalMaterial3Api::class)

package mindtech.homework.pokemonassignment.ui.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import mindtech.homework.pokemonassignment.data.entities.PokemonDetails
import mindtech.homework.pokemonassignment.data.entities.Type
import mindtech.homework.pokemonassignment.viewmodels.PokemonListViewModel

@Composable
fun PokemonListScreen(
    viewModel: PokemonListViewModel = hiltViewModel(),
    navigateToDetails: (String) -> Unit
){
    PokemonListScreenContent(
        viewModel,
        navigateToDetails,
    )
}

@Composable
fun PokemonListScreenContent(
    viewModel: PokemonListViewModel,
    navigateToDetails: (String) -> Unit
) {

    LaunchedEffect(Unit) {
        viewModel.getTypes()
        viewModel.getCatchedPokemon()
    }

    val scope = rememberCoroutineScope()

    Column {
        SearchBarItem(){
            viewModel.getPokemonsByName(it)
        }
        TypeSelector(
            viewModel
        ) {
            viewModel.getPokemonsByTypeId(it)
        }
        ResultList(
            viewModel,
            onItemClicked = {
                navigateToDetails(it.name)
            },
            onCatchClicked = {
                scope.launch {
                    viewModel.insert(it)
                }
            },
            onReleaseClicked = {
                scope.launch {
                    viewModel.delete(it)
                }
            }
        )
    }
}

@Composable
fun ResultList(
    viewModel: PokemonListViewModel,
    onItemClicked: (PokemonDetails) -> Unit,
    onCatchClicked: (PokemonDetails) -> Unit,
    onReleaseClicked: (PokemonDetails) -> Unit
) {
    val typeResult by viewModel.result.collectAsStateWithLifecycle()
    val catchedPokemons by viewModel.catchedPokemons.collectAsStateWithLifecycle()

    LazyColumn {
        items(typeResult){
            var isCaught = false
            for(pokemon in catchedPokemons){
                if(pokemon.name == it.name){
                    isCaught = true
                }
            }
            Row{
                Card(
                    modifier = Modifier.clickable {
                        onItemClicked(it) }
                        .border(1.dp, if(isCaught) Color.Yellow else Color.Blue)
                ) {
                    Row {
                        Text(it.name)
                    }
                }
                Button(
                    onClick = {
                        if(isCaught) onReleaseClicked(it)
                        else onCatchClicked(it)
                    }
                ){
                    Text(
                        text= if(isCaught) "Release"
                        else "Catch"
                    )
                }
            }
        }
    }
}

@Composable
fun TypeSelector(
    viewModel: PokemonListViewModel,
    onTypeSelected: (Type) -> Unit
) {
    val typeList by viewModel.typeList.collectAsStateWithLifecycle()

    Column {
        Text("Pokemon Types")
        TypeSelectorDropDownMenu(
            typeList,
            onTypeSelected
        )
        OnlyShow()
    }
}

@Composable
fun OnlyShow() {
}

@Composable
fun TypeSelectorDropDownMenu(
    typeList: List<Type>,
    onTypeSelected: (Type) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf( Type()) }

    ExposedDropdownMenuBox(
        expanded = expanded, onExpandedChange = {
        expanded = !expanded
    }) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = selectedOption.name,
            onValueChange = {},
            label = { Text("Select..." ) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            typeList.forEach { type ->
                DropdownMenuItem(
                    text = { Text(type.name) },
                    onClick = {
                        selectedOption = type
                        expanded = false
                        onTypeSelected(selectedOption)
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}

@Composable
fun SearchBarItem(
    onSearchQueryChange: (String) -> Unit
) {

    val searchText = remember {
        mutableStateOf("")
    }

    Row {
        OutlinedTextField(
            value = searchText.value,
            onValueChange = {
                searchText.value = it
            }
        )
        Button(onClick = {  onSearchQueryChange(searchText.value) }) {
            Text("Search")
        }
    }
}
