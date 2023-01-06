package ru.seterovas.gamesapp.data.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.seterovas.gamesapp.data.remote.models.GameModel
import ru.seterovas.gamesapp.data.remote.models.SpecificGameModel
import javax.inject.Inject

class GameService @Inject constructor(private val gameApi: GameApi) {

    suspend fun getGames(): List<GameModel>{
        return withContext(Dispatchers.IO){
            val games = gameApi.getGames()
            games.body() ?: emptyList()
        }
    }

    suspend fun getGamesById(id: Int): SpecificGameModel{
        return withContext(Dispatchers.IO){
            val game = gameApi.getGameById(id)
            game.body()!!
        }
    }

}