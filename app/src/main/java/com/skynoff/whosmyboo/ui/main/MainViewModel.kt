package com.skynoff.whosmyboo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skynoff.whosmyboo.models.Player

class MainViewModel : ViewModel() {
    var player = Player("", "", 18, "", "")
    var gameList = MutableLiveData<List<GameOption>>()
    fun setFullName(formName: String, formlastName: String) {
        player.apply {
            name = formName
            lastname = formlastName
        }
    }

    fun setAge(formAge: Int) {
        player.age = formAge
    }

    fun setCountry(formCountry: String) {
        player.country = formCountry
    }

    fun getDummyGameList(){
        gameList = MutableLiveData()
        gameList.value = listOf(GameOption("My crush","love","goToCrush"),GameOption("Other Game","love","goToGame"),GameOption("Other Game","love","goToGame"))
    }
}
