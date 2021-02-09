package com.example.dicethrowingapp

import androidx.lifecycle.ViewModel

class DiceRollingViewModel : ViewModel() {
    var diceRollingUI : DiceRollingUI = DiceRollingUI()

    fun rollDice() {
        if (diceRollingUI.numberOfThrows < 3) {
            if(diceRollingUI.firstDie.value?.isSelected == false) {
                diceRollingUI.firstDie.value = DieUI(roll(), false)
            }
            if(diceRollingUI.secondDie.value?.isSelected == false) {
                diceRollingUI.secondDie.value = DieUI(roll(), false)
            }
            if(diceRollingUI.thirdDie.value?.isSelected == false) {
                diceRollingUI.thirdDie.value = DieUI(roll(), false)
            }
            if(diceRollingUI.fourthDie.value?.isSelected == false) {
                diceRollingUI.fourthDie.value = DieUI(roll(), false)
            }
            if(diceRollingUI.fifthDie.value?.isSelected == false) {
                diceRollingUI.fifthDie.value = DieUI(roll(), false)
            }
            if(diceRollingUI.sixthDie.value?.isSelected == false) {
                diceRollingUI.sixthDie.value = DieUI(roll(), false)
            }
        }
        diceRollingUI.numberOfThrows++
    }

    private fun roll() : Int{
        return (1..6).random()
    }

    fun selectDie(index: Int) {
        diceRollingUI.select(index)
    }

    fun resetDice() {
        diceRollingUI.firstDie.value!!.reset()
        diceRollingUI.secondDie.value!!.reset()
        diceRollingUI.thirdDie.value!!.reset()
        diceRollingUI.fourthDie.value!!.reset()
        diceRollingUI.fifthDie.value!!.reset()
        diceRollingUI.sixthDie.value!!.reset()

        diceRollingUI.numberOfThrows = 0
    }
}