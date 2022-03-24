package com.example.challengechaptertiga

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // This if else will set text that appear on screen 3
        if(arguments?.containsKey("PERSON") == true){
            val person = arguments?.getParcelable<Person>("PERSON")
            val nama = person?.nama
            val usia = person?.usia
            val alamat = person?.alamat
            val pekerjaan = person?.pekerjaan
            val ganjilGenap = if(usia?.rem(2) == 0){
                "Genap"
            }else{
                "Ganjil"
            }
            output.text = "$nama\n" +
                    "$usia, $ganjilGenap\n" +
                    "$alamat\n" +
                    "$pekerjaan"
        }else{
            val nama = arguments?.getString("NAMA")
            output.text = nama
        }
        // action for button gotosreen4
        gotoscreen4.setOnClickListener {
            // to get name, we check if person bundle already exist or not
            val nama = if(arguments?.containsKey("PERSON") == true){
                arguments?.getParcelable<Person>("PERSON")?.nama
            }else{
                arguments?.getString("NAMA")
            }
            val bundleNama = bundleOf("NAMA" to nama)
            // navigate to screen 4
            Navigation.findNavController(view).navigate(R.id.third_to_fourth_fragment, bundleNama)
        }
    }
}