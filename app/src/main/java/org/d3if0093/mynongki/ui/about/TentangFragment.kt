package org.d3if0093.mynongki.ui.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.d3if0093.mynongki.R
import org.d3if0093.mynongki.databinding.FragmentTentangBinding

class TentangFragment : Fragment() {

    private lateinit var binding: FragmentTentangBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTentangBinding.inflate(inflater, container, false)
        return binding.root
    }
}