package com.skynoff.whosmyboo.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.skynoff.whosmyboo.R
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    private val viewModel by inject<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getGameList()
        recycler_game_options.layoutManager = GridLayoutManager(context, 2)

        viewModel.gameList.observe(this, Observer { gameList ->
            recycler_game_options.adapter = GameOptionAdapter(context!!, gameList)
            recycler_game_options.adapter?.notifyDataSetChanged()
        })
    }
}
