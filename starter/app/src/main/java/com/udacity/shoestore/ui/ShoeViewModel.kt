package com.udacity.shoestore.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel(){
    var mutableLiveData:MutableLiveData<ArrayList<Shoe>> = MutableLiveData()
    private val description = "A748 is a shoe made by Niki for sports and heavy mobility"

    fun setShoes(){
        val arr : ArrayList<Shoe> = ArrayList()
        arr.add(Shoe("A748" , 38.0 ,"Niki" , description ))
        arr.add(Shoe("A749" , 39.0 ,"Meow" , description ))
        arr.add(Shoe("A750" , 42.0 ,"FILA" , description ))
        arr.add(Shoe("A751" , 43.0 ,"Air Jordan" , description ))
        arr.add(Shoe("A752" , 39.6 ,"Puma" , description ))
        arr.add(Shoe("A753" , 41.4 ,"Adidas" , description ))
        mutableLiveData.value = arr
    }

}
