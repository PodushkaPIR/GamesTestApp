package ru.seterovas.gamesapp.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.seterovas.gamesapp.data.remote.models.GameModel
import ru.seterovas.gamesapp.data.remote.models.SpecificGameModel
import ru.seterovas.gamesapp.util.Constants.Companion.GAMES_ENDPOINT
import ru.seterovas.gamesapp.util.Constants.Companion.GAMES_ID_ENDPOINT

interface GameApi {

    @GET(GAMES_ENDPOINT)
    suspend fun getGames():  Response<List<GameModel>>

    @GET(GAMES_ID_ENDPOINT)
    suspend fun getGameById(@Query(value = "id") id: Int): Response<SpecificGameModel>
}