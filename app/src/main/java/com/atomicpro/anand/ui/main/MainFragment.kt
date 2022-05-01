package com.atomicpro.anand.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.atomicpro.anand.R
import com.atomicpro.anand.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private  var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        _binding =  MainFragmentBinding.bind(view)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.actions, menu)
        super.onCreateOptionsMenu(menu,inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.refresh -> updateValue()
            else -> {}
        }
        return false
    }
    private fun setView() {
        binding.sportTitle.applyFontSize(24.00f, Color.GRAY)
        binding.sportDescription.applyFontSize(18.00f, Color.GRAY)

        viewModel.quoteModel.observe(viewLifecycleOwner) { currentQuote ->
            binding.sportTitle.text = currentQuote.name
            binding.sportDescription.text = currentQuote.description
        }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.loading.isVisible = it
        }
        updateValue()
    }

    private fun updateValue(){
        viewModel.getFeaturedFromSports()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}