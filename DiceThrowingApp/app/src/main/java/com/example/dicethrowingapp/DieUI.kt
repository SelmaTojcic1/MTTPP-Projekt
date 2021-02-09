package com.example.dicethrowingapp

data class DieUI(
        var value: Int = 0,
        var isSelected: Boolean = false
) {

    fun reset() {
        value = 1
    }

    fun select() {
        isSelected = !isSelected
    }

    fun getImage() : Int {
        return when (value) {
            1 -> R.drawable.die1
            2 -> R.drawable.die2
            3 -> R.drawable.die3
            4 -> R.drawable.die4
            5 -> R.drawable.die5
            else -> R.drawable.die6
        }
    }
}