package org.d3if0093.mynongki.ui.tambah

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.d3if0093.mynongki.R
import org.d3if0093.mynongki.databinding.FragmentTambahBinding
import org.d3if0093.mynongki.db.entity.MyEntity
import org.d3if0093.mynongki.db.viewmodel.MyViewModel

class TambahFragment : Fragment() {

    private lateinit var binding: FragmentTambahBinding

    private val viewModel: MyViewModel by lazy {
        ViewModelProvider(this).get(MyViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTambahBinding.inflate(inflater, container, false)

        binding.inputBtn.setOnClickListener{
            tambahData()
        }
        return binding.root
    }

    private fun tambahData(){
        val btn = binding.switchTheme.

        val name = binding.editTxtName.text.toString()
        val address = binding.editTxtAddress.text.toString()
        val num = binding.editTxtNumber.text.toString()
        val desc = binding.editTxtDesc.text.toString()

        if (!(name.isBlank() || address.isBlank() || desc.isBlank() || num.isBlank())){
            val data = MyEntity(0, name, address, desc, num)
            viewModel.tambahData(data)
            findNavController().navigate(R.id.action_tambahFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "!", Toast.LENGTH_SHORT).show()
        }
    }
}