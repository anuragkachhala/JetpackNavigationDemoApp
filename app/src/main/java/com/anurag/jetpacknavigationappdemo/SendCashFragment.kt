package com.anurag.jetpacknavigationappdemo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_send_cash.*


class SendCashFragment : Fragment(R.layout.fragment_send_cash) {

    private val args: SendCashFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etMoney.setText(SampleData.defaultAmount.toString())
        SampleData.defaultAmount.observe(viewLifecycleOwner){
            etMoney.setText(it.toString())
        }
        // val receiverName = arguments?.getString("name")
        val navController = findNavController()
        val directAction = SendCashFragmentDirections
        val receiverName = args.receiverName
        tvReceiverName.text = "Send cash to $receiverName"

        val amount = etMoney.text

        btnSend.setOnClickListener {
            navController.navigate(
                directAction.actionSendCashFragmentToConfimDialogFragment(
                    receiverName,
                    amount = amount.toString().toLong()
                )
            )
        }

        btnDone.setOnClickListener {
            navController.navigate(directAction.actionSendCashFragmentToHomeFragment())
        }

        btnCancel.setOnClickListener {
            navController.popBackStack(R.id.homeFragment, true)
        }

    }
}