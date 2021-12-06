package com.anurag.jetpacknavigationappdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_notifition.*


class NotificationFragment : Fragment(R.layout.fragment_notifition) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            getNotificationList()
        )
    }

    private fun getNotificationList(): ArrayList<String> {

        val list = ArrayList<String>()
        for (i in 1..20) {
            list.add("Notification $i")
        }

        return list
    }
}