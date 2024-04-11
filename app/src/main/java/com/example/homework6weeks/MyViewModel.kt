package com.example.homework6weeks

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModel : ViewModel(){
    val countLiveData: MutableLiveData<Int> = MutableLiveData<Int>()

    fun increaseCount() {
        countLiveData.value = (countLiveData.value ?:0)+1
    }

    fun decreaseCount() {
        countLiveData.value = (countLiveData.value ?:0)-1
    }

}

class MyViewModel2(count:String) : ViewModel(){
    var count=Integer.parseInt(count)
    val countLiveData: MutableLiveData<Int> = MutableLiveData<Int>()

    init {
        countLiveData.value=this.count
    }

    fun increaseCount() {
        count++
        countLiveData.value = (countLiveData.value ?:0)+1
    }

    fun decreaseCount() {
        count--
        countLiveData.value = (countLiveData.value ?:0)-1
    }

}

class MyViewModel2Factorial(val count: String) : ViewModelProvider.Factory{
    override fun <T :  ViewModel> create(modelClass: Class<T>): T{
        @Suppress("UNCHECKED_CAST")
        return MyViewModel2(count) as T // the warning 'unchecked cast' is unavoidable.
    }
}