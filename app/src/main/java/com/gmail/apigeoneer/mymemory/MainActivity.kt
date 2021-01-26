package com.gmail.apigeoneer.mymemory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs: TextView
    private lateinit var rvBoard: RecyclerView
    private lateinit var llGameInfo: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvNumMoves = findViewById(R.id.numMoves_text)
        tvNumPairs = findViewById(R.id.numPairs_text)
        rvBoard = findViewById(R.id.board_recycler)
        llGameInfo = findViewById(R.id.game_info_linear)

        rvBoard.adapter = MemoryBoardAdapter(this, 8)
        rvBoard.setHasFixedSize(true)
        rvBoard.layoutManager = GridLayoutManager(this, 2)
    }
}