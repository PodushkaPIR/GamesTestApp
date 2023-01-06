package ru.seterovas.gamesapp.domain

import ru.seterovas.gamesapp.domain.items.GameItem
import ru.seterovas.gamesapp.repo.GameRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val gamerRepository: GameRepository){

    suspend operator fun invoke(): List<GameItem> {
        return gamerRepository.getGames().shuffled()
    }
}