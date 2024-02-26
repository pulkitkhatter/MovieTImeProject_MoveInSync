import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.MovieListFinal
import com.example.myapplication.R

class MovieAdapterF2(private val movies: List<MovieListFinal>) :
    RecyclerView.Adapter<MovieAdapterF2.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
        val movieName: TextView = itemView.findViewById(R.id.movieName)
        val movieGenre: TextView = itemView.findViewById(R.id.movieGenre)
        val movieRating: TextView = itemView.findViewById(R.id.movieRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movies[position]
        holder.movieName.text = currentMovie.title
        holder.movieGenre.text = currentMovie.genre
        holder.movieRating.text = currentMovie.rating.toString()
        Glide.with(holder.itemView)
            .load(currentMovie.imageUrl)
            .into(holder.movieImage)
    }

    override fun getItemCount() = movies.size
}
