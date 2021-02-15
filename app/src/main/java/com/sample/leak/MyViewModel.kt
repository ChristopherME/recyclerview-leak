package com.sample.leak

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    private val _items = MutableLiveData<List<String>>()
    val items: LiveData<List<String>>
        get() = _items

    init {
        _items.value = provideItems()
    }

    private fun provideItems(): List<String> {
        val items = ArrayList<String>()
        for (item in 0 .. 10) {
            items.add("$item")
        }
        return items
    }
}