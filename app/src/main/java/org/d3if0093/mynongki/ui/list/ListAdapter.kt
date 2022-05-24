package org.d3if0093.mynongki.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*
import org.d3if0093.mynongki.R
import org.d3if0093.mynongki.db.entity.MyEntity

class ListAdapter: RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    class ListViewHolder(listView: View): RecyclerView.ViewHolder(listView){}

    private var myList = emptyList<MyEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentList = myList[position]
        holder.itemView.nameList.text = currentList.nameNongki
        holder.itemView.addressList.text = currentList.addressNongki
        holder.itemView.descList.text = currentList.descNongki
        holder.itemView.numList.text = currentList.numNongki

        holder.itemView.currentList.setOnClickListener{
            val move = ListFragmentDirections.actionListFragmentToContentFragment(currentList)
            holder.itemView.findNavController().navigate(move)
        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(list: List<MyEntity>){
        this.myList = list
        notifyDataSetChanged()
    }
}