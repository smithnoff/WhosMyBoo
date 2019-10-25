package com.skynoff.whosmyboo.models

data class Player(
    var name: String?,
    var lastname: String?,
    var age: Int?,
    var country: String?,
    var email: String?,
    var gender : GameGenders = GameGenders.Other()
)