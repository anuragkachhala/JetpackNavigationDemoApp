package com.anurag.jetpacknavigationappdemo

import androidx.lifecycle.MutableLiveData

class SampleData {


    companion object{
         var defaultAmount = MutableLiveData<Long>(100L)
    }

}