package com.example.challengechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //action for gotoscreen3 button
        gotoscreen3.setOnClickListener {
            if(input_nama.text.isNotEmpty()){
                // get item "nama", then bundle that item into namaBundle
                val nama = input_nama.text.toString()
                val namaBundle = bundleOf("NAMA" to nama)
                // navigate to screen 3
                Navigation.findNavController(view).navigate(R.id.second_to_third_fragment, namaBundle)
            }else{
                Toast.makeText(gotoscreen3.context, "Field nama harus diisi", Toast.LENGTH_SHORT).show()
            }

        }
    }
}