package com.afdhal_fa.unittestsample.movie.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.afdhal_fa.unittestsample.databinding.ItemMovieBinding
import com.afdhal_fa.unittestsample.movie.domain.entity.Movie
import com.afdhal_fa.unittestsample.movie.util.loadImage

/**
 * Created by Muh Fuad Afdhal on 10/3/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class MovieRecyclerAdapter : ListAdapter<Movie, MovieRecyclerAdapter.VHolder>(diffCallback) {
    private var onMovieSelected :(Movie)->Unit ={}


    class VHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(parent:ViewGroup):VHolder{
                val  layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMovieBinding.inflate(layoutInflater,parent,false)
                return VHolder(binding)
            }
        }

        fun bind(movie: Movie, onMovieSelected: (Movie) -> Unit) {
            binding.ivMovie.loadImage(movie.imageUrl)
            binding.root.setOnClickListener { onMovieSelected(movie) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        return VHolder.create(parent)
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.bind(getItem(position),onMovieSelected)

    }

    fun setOnMovieSelected(block : (Movie)-> Unit){
        this.onMovieSelected = block
    }

    companion object{
        val diffCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

}