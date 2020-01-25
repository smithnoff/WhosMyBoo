package com.skynoff.whosmyboo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.skynoff.whosmyboo.models.Player
import org.koin.core.KoinComponent


class MainViewModel : ViewModel(), KoinComponent {

    var player = Player("", "", 18, "", "")
    var gameList = MutableLiveData<MutableList<GameOption>>()
    val db = FirebaseFirestore.getInstance()

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

    fun getGameList() {
        db.collection("Games").get().addOnSuccessListener {
            val gameOptions = mutableListOf<GameOption>()
            it.documents.forEach { option ->
                gameOptions.add(option.toObject(GameOption::class.java) ?: GameOption())
            }
            gameList.postValue(gameOptions)
        }
    }
}
