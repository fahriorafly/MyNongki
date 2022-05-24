package org.d3if0093.mynongki.ui.content

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_content.view.*
import org.d3if0093.mynongki.R
import org.d3if0093.mynongki.databinding.FragmentContentBinding
import org.d3if0093.mynongki.db.viewmodel.MyViewModel

class ContentFragment : Fragment() {

    private val viewModel: MyViewModel by lazy {
        ViewModelProvider(this).get(MyViewModel::class.java)
    }
    private lateinit var binding: FragmentContentBinding
    private val args by navArgs<ContentFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentContentBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        val view = binding.root

        view.nameViewContent.setText(args.currentList.nameNongki)
        view.addressViewContent.setText(args.currentList.addressNongki)
        view.numViewContent.setText(args.currentList.numNongki)
        view.descViewContent.setText(args.currentList.descNongki)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_content, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.delete -> {
                deleteList()
                true
            }
            R.id.share -> {
                shareList()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }

    private fun deleteList(){
        MaterialAlertDialogBuilder(requireContext())
            .setMessage("Message")
            .setPositiveButton("YA"){_, _ ->
                viewModel.hapusData(args.currentList)
                findNavController().navigate(R.id.action_contentFragment_to_listFragment)
            }
            .setNegativeButton("TIDAK"){ dialog, _ ->
                dialog.cancel()
            }
            .show()
    }

    private fun shareList(){
        val message = getString(R.string.template,
            args.currentList.nameNongki,
            args.currentList.addressNongki,
            args.currentList.descNongki
        )

        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (intent.resolveActivity(requireActivity().packageManager) != null){
            startActivity(intent)
        }
    }
}