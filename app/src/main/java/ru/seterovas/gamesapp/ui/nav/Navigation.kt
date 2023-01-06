package ru.seterovas.gamesapp.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.seterovas.gamesapp.ui.screens.DetailScreen
import ru.seterovas.gamesapp.ui.screens.HomeScreen
import ru.seterovas.gamesapp.ui.vm.GameViewModel
import ru.seterovas.gamesapp.util.Constants
import ru.seterovas.gamesapp.util.Constants.Companion.KEY_GAME_ID

sealed class Screens(val route: String){
    object Home: Screens(route = Constants.Screens.HOME_SCREEN)
    object Detail: Screens(route = Constants.Screens.DETAIL_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController, gameViewModel: GameViewModel){
    NavHost(navController = navController, startDestination = Screens.Home.route){
        composable(route = Screens.Home.route){
            HomeScreen(gameViewModel = gameViewModel, navController = navController)
        }
        composable(route = Screens.Detail.route + "/{$KEY_GAME_ID}"){ backStackEntry ->
            DetailScreen(id = backStackEntry.arguments?.getString(KEY_GAME_ID) ?: "1", gameViewModel = gameViewModel, navController = navController)
        }
    }
}