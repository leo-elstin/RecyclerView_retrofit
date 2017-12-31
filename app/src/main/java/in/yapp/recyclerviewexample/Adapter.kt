package `in`.yapp.recyclerviewexample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.adapter.view.*

/**
 * Created by elstin on 12/30/2017.
 */
class Adapter constructor(private val list: List<User>, private val context: Context) : RecyclerView.Adapter<Adapter.setUpData>() {

    override fun onBindViewHolder(holder: setUpData, position: Int) {

        holder.dataBind(list[position], context)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): setUpData {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter, parent, false)
        return setUpData(view)
    }

    class setUpData(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun dataBind(data: User, context: Context) {

            // No more find ViewByID

            itemView.name.text = data.name
            itemView.location.text = data.location

        }
    }
}