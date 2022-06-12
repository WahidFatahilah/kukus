package com.bangkit.kukus.ui.diary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class DiaryViewModel : ViewModel() {

    private var _kaloriTotal = MutableLiveData<Int>()
    var nomor: LiveData<Int> = _kaloriTotal



}