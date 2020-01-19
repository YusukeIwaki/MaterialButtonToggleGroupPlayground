package io.github.yusukeiwaki.materialbuttontogglegroupplayground

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    val title = MutableLiveData<String>()
    val closedOnSun = MutableLiveData<Boolean>()
    val closedOnMon = MutableLiveData<Boolean>()
    val closedOnTue = MutableLiveData<Boolean>()
    val closedOnWed = MutableLiveData<Boolean>()
    val closedOnThu = MutableLiveData<Boolean>()
    val closedOnFri = MutableLiveData<Boolean>()
    val closedOnSat = MutableLiveData<Boolean>()
}
