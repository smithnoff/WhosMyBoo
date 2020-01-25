package com.skynoff.whosmyboo.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.skynoff.whosmyboo.R
import kotlinx.android.synthetic.main.item_game_option.view.*

class GameOptionAdapter(private val context: Context, list: List<GameOption>) :
    RecyclerView.Adapter<GameOptionAdapter.GameOptionviewHolder>() {

    private val gameOptionList = list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameOptionviewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_game_option, parent, false)
        return GameOptionviewHolder(view)
    }

    override fun getItemCount(): Int {
        return gameOptionList.size
    }

    override fun onBindViewHolder(holder: GameOptionviewHolder, position: Int) {
        holder.bindOptionView(gameOptionList[position])
    }


    class GameOptionviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindOptionView(option: GameOption) {
            itemView.item_title.text = option.title
            itemView.setOnClickListener {
                when (option.action) {
                    "goToCrush" -> {
                        it.findNavController().navigate(R.id.action_mainFragment_to_gamesFragment)
                    }
                }
            }
        }
    }

}
