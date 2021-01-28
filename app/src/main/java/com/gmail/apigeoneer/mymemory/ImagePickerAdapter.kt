package com.gmail.apigeoneer.mymemory

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.apigeoneer.mymemory.models.BoardSize

class ImagePickerAdapter(
    private val context: Context,
    private val chosenImageUris: List<Uri>,
    private val boardSize: BoardSize
) : RecyclerView.Adapter<ImagePickerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_image, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = boardSize.getNumPairs()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // No-op
    }

}
