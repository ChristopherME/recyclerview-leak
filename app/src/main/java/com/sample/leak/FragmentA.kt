package com.sample.leak

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sample.leak.databinding.FragmentABinding


class FragmentA : Fragment() {

    private val myViewModel by viewModels<MyViewModel>()
    private val adapter = MyAdapter(listOf())

    private var _binding: FragmentABinding? = null
    private val binding: FragmentABinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvItems.adapter = adapter

        binding.btnNext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, FragmentB())
                .addToBackStack(null)
                .commit()
        }

        myViewModel.items.observe(viewLifecycleOwner) {
            adapter.bindItems(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}