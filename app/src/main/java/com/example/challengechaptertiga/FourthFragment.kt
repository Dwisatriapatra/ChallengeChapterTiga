package com.example.challengechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_fourth.*

class FourthFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // action for backtoscreen3 button
        backtoscreen3.setOnClickListener {
            // check if all field is filled
            if(input_usia.text.isNotEmpty() && input_alamat.text.isNotEmpty() && input_pekerjaan.text.isNotEmpty()){
                //check if "usia" is a number or not
                if(input_usia.text.toString().all { Character.isDigit(it) }){
                    // get all of item and bundling them into personBundle
                    val nama = arguments?.getString("NAMA")
                    val usia = input_usia.text.toString().toInt()
                    val alamat = input_alamat.text.toString()
                    val pekerjaan = input_pekerjaan.text.toString()
                    val person = Person(nama, usia, alamat, pekerjaan)
                    val personBundle = bundleOf("PERSON" to person)
                    // navigate to screen 3
                    Navigation.findNavController(view).navigate(R.id.fourth_to_third_fragment, personBundle)
                }else{
                    Toast.makeText(backtoscreen3.context, "Field usia harus berupa angka", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(backtoscreen3.context, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}