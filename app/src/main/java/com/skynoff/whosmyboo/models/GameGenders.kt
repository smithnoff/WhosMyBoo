package com.skynoff.whosmyboo.models

sealed class GameGenders {
    class Male(val value: String = "Male") : GameGenders()
    class Female(val value: String ="Female") : GameGenders()
    class Other(val value: String ="Other") : GameGenders()
}
