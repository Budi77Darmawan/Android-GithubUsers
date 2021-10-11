package com.bd_drmwan.githubusers.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bd_drmwan.githubusers.models.Resource
import com.bd_drmwan.githubusers.databinding.FragmentHomeBinding
import com.bd_drmwan.githubusers.viewmodels.AppViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val appViewModel by viewModels<AppViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tv.setOnClickListener {
            appViewModel.getUsersByUsername("budi")
        }

        observeLiveData()
    }

    private fun observeLiveData() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            appViewModel.listUserByQuery.collect {
                when (it) {
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                    }
                    is Resource.Error -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}