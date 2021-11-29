package com.example.kipmnotes.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kipmnotes.R
import com.example.kipmnotes.databinding.FragmentHomeBinding
import com.example.kipmnotes.databinding.ProgrammingLanguageBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ProgrammingLanguage : Fragment() {

    private var _binding : ProgrammingLanguageBinding? = null
    private var param1: String? = null
    private var param2: String? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ProgrammingLanguageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }






    companion object {
        fun newInstance(param1: String, param2: String) =
            ProgrammingLanguage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}