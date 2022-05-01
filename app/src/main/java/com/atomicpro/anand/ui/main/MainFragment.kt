package com.atomicpro.anand.ui.main

import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.atomicpro.anand.R
import com.atomicpro.anand.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        binding =  MainFragmentBinding.bind(view)
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

    companion object {
        fun newInstance() = MainFragment()
    }
}