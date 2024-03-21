import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodo.databinding.FragmentTaskItemBinding

// Adapter is responsible for managing the display of the list –binding data with the views
class MyTaskRecyclerViewAdapter(
    private val values: List<Task>
): RecyclerView.Adapter<MyTaskRecyclerViewAdapter.ViewHolder>()
{
    // onCreateViewHolder creates the ViewHolder objects
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyTaskRecyclerViewAdapter.ViewHolder {
// create the view holders for the recycler view items
// no data is bound to the views yet
        return ViewHolder(
            FragmentTaskItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // The ViewHolder class is a container for the views in the recycler view item
    class ViewHolder(binding: FragmentTaskItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        val imgView: ImageView = binding.itemImg
        val contentView: TextView = binding.content
        val itemContainer: View = binding.root
        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

    override fun onBindViewHolder(holder: MyTaskRecyclerViewAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}