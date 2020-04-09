package com.diki.idn.guesstheword.opening

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.diki.idn.guesstheword.R
import com.diki.idn.guesstheword.databinding.FragmentOpeningBinding

/**
 * A simple [Fragment] subclass.
 */
class OpeningFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentOpeningBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_opening, container, false
        )

        binding.playGameButton.setOnClickListener {
            findNavController().navigate(OpeningFragmentDirections.actionOpeningDestinationToGameDestination2())
        }
        return binding.root
    }
}