package org.d3if0093.mynongki.ui.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.view.*
import org.d3if0093.mynongki.R
import org.d3if0093.mynongki.databinding.FragmentListBinding
import org.d3if0093.mynongki.db.viewmodel.MyViewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val viewModel: MyViewModel by lazy {
        ViewModelProvider(this).get(MyViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)

        val view = binding.root
        setHasOptionsMenu(true)

        val adapter = ListAdapter()
        val recycleView = view.recyclerView
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getAllData.observe(viewLifecycleOwner, Observer { list ->
            adapter.setData(list)
        })
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.tambahData -> {
                findNavController().navigate(
                    R.id.action_listFragment_to_tambahFragment
                )
                true
            }
            R.id.tentang -> {
                findNavController().navigate(
                    R.id.action_listFragment_to_aboutFragment
                )
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}