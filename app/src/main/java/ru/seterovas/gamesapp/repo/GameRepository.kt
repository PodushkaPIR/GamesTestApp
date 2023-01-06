package ru.seterovas.gamesapp.repo

import ru.seterovas.gamesapp.data.remote.GameService
import ru.seterovas.gamesapp.domain.items.GameItem
import ru.seterovas.gamesapp.domain.items.SpecificGameItem
import ru.seterovas.gamesapp.domain.items.toGameItem
import ru.seterovas.gamesapp.domain.items.toSpecificGameItem
import javax.inject.Inject

class GameRepository @Inject constructor(private val gameService: GameService) {

    suspend fun getGames(): List<GameItem> {
        return gameService.getGames().map {
            it.toGameItem()
        }
    }

    suspend fun getGameById(id: Int): SpecificGameItem {
        return gameService.getGamesById(id).toSpecificGameItem()
    }
}