package com.anurag.jetpacknavigationappdemo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_choose_receiver.*


class ChooseReceiverFragment : Fragment(R.layout.fragment_choose_receiver) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        val directions = ChooseReceiverFragmentDirections

        btnSend.setOnClickListener {
            val receiverName = etReceiverName.text.toString().trim()
            /* val args = Bundle()
            args.putString("name",receiverName)*/
            navController.navigate(
                directions.actionChooseReceiverFragmentToSendCashFragment(
                    receiverName
                )
            )
        }

        btnCancel.setOnClickListener {
            navController.popBackStack()
        }


    }
}