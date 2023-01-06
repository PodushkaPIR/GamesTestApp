package ru.seterovas.gamesapp.domain

import ru.seterovas.gamesapp.domain.items.SpecificGameItem
import ru.seterovas.gamesapp.repo.GameRepository
import javax.inject.Inject

class GetGameByIdUseCase @Inject constructor(private val gameRepository: GameRepository){
    suspend operator fun invoke(id: Int): SpecificGameItem {
        return gameRepository.getGameById(id)
    }
}