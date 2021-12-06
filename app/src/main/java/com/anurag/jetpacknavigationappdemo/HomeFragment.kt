package com.anurag.jetpacknavigationappdemo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navDirections = HomeFragmentDirections
        val navOption = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_right)
            .setExitAnim(R.anim.slide_out_left)
            .setPopEnterAnim(R.anim.slide_in_left)
            .setPopExitAnim(R.anim.slide_out_right)
            .build()

        val navController = findNavController()
        btnSendMoney.setOnClickListener {
            //navController.navigate(R.id.action_homeFragment_to_viewBalanceFragment)
            navController.navigate(navDirections.actionHomeFragmentToChooseReceiverFragment())
        }

        btnViewBalance.setOnClickListener {
            navController.navigate(navDirections.actionHomeFragmentToViewBalanceFragment(),navOption)
        }

        btnViewTransation.setOnClickListener {
            navController.navigate(navDirections.actionHomeFragmentToViewTransationFragment(),navOption)
        }

    }
}