package com.example.forthegloryoftheburak.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.forthegloryoftheburak.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {
    val viewmodel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.getRockets2()
    }
}