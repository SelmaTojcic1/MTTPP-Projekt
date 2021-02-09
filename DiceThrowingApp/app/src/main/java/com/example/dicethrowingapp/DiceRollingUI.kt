package com.example.dicethrowingapp

import androidx.lifecycle.MutableLiveData

class DiceRollingUI () {
    var numberOfThrows : Int = 0

    var firstDie : MutableLiveData<DieUI> = MutableLiveData(DieUI())
    var secondDie : MutableLiveData<DieUI> = MutableLiveData(DieUI())
    var thirdDie : MutableLiveData<DieUI> = MutableLiveData(DieUI())
    var fourthDie : MutableLiveData<DieUI> = MutableLiveData(DieUI())
    var fifthDie : MutableLiveData<DieUI> = MutableLiveData(DieUI())
    var sixthDie : MutableLiveData<DieUI> = MutableLiveData(DieUI())

    fun select(index: Int){
        if(numberOfThrows == 1 || numberOfThrows == 2){
            when (index) {
                0 -> firstDie.value?.select()
                1 -> secondDie.value?.select()
                2 -> thirdDie.value?.select()
                3 -> fourthDie.value?.select()
                4 -> fifthDie.value?.select()
                5 -> sixthDie.value?.select()
            }
        }
    }

    fun getDiceValues() : IntArray {
        val diceValues = IntArray(6)
        diceValues[0] = firstDie.value?.value!!
        diceValues[1] = secondDie.value?.value!!
        diceValues[2] = thirdDie.value?.value!!
        diceValues[3] = fourthDie.value?.value!!
        diceValues[4] = fifthDie.value?.value!!
        diceValues[5] = sixthDie.value?.value!!
        return diceValues
    }
}