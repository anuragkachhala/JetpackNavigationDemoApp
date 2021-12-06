package com.anurag.jetpacknavigationappdemo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_setting.*


class SettingFragment : Fragment(R.layout.fragment_setting) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         amountEt.setText(SampleData.defaultAmount.value.toString())

        btnSave.setOnClickListener {
            val defaultAmount = amountEt.text.toString().toLong()
            SampleData.defaultAmount.value = defaultAmount
        }

        abountAppBtn.setOnClickListener{
            val action = NavGraphDirections.actionGlobalAbounAppFragment()
            findNavController().navigate(action)
        }
    }
}