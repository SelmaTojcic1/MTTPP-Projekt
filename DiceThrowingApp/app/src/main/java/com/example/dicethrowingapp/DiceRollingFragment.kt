package com.example.dicethrowingapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_dice_rolling.*


class DiceRollingFragment : Fragment(R.layout.fragment_dice_rolling), View.OnClickListener {

    private var diceRollingViewModel: DiceRollingViewModel = DiceRollingViewModel()
    private var message = "Number of rolls left: " + diceRollingViewModel.diceRollingUI.numberOfThrows.toString()

    companion object {
        fun newInstance() = DiceRollingFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        diceRollingViewModel = ViewModelProvider(this).get(DiceRollingViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        initObservers()

    }

    private fun initListeners() {
        btn_roll.setOnClickListener {
            diceRollingViewModel.rollDice()
        }

        btn_reset.setOnClickListener {
            diceRollingViewModel.resetDice()
        }

        btn_rolls_left.setOnClickListener {
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        }

        image_view_dice_1.setOnClickListener(this)
        image_view_dice_2.setOnClickListener(this)
        image_view_dice_3.setOnClickListener(this)
        image_view_dice_4.setOnClickListener(this)
        image_view_dice_5.setOnClickListener(this)
        image_view_dice_6.setOnClickListener(this)
    }

    private fun initObservers() {
        diceRollingViewModel.diceRollingUI.firstDie.observe(this) {
            setImageResources(0)
        }
        diceRollingViewModel.diceRollingUI.secondDie.observe(this) {
            setImageResources(1)
        }
        diceRollingViewModel.diceRollingUI.thirdDie.observe(this) {
            setImageResources(2)
        }
        diceRollingViewModel.diceRollingUI.fourthDie.observe(this) {
            setImageResources(3)
        }
        diceRollingViewModel.diceRollingUI.fifthDie.observe(this) {
            setImageResources(4)
        }
        diceRollingViewModel.diceRollingUI.sixthDie.observe(this) {
            setImageResources(5)
        }

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            image_view_dice_1.id  -> diceRollingViewModel.selectDie(0)
            image_view_dice_2.id  -> diceRollingViewModel.selectDie(1)
            image_view_dice_3.id  -> diceRollingViewModel.selectDie(2)
            image_view_dice_4.id  -> diceRollingViewModel.selectDie(3)
            image_view_dice_5.id  -> diceRollingViewModel.selectDie(4)
            image_view_dice_6.id  -> diceRollingViewModel.selectDie(5)
        }
    }

    private fun setImageResources(index : Int) {
        if(diceRollingViewModel.diceRollingUI.numberOfThrows < 3) {
            when (index) {
                0 -> diceRollingViewModel.diceRollingUI.firstDie.value?.let { image_view_dice_1.setImageResource(it.getImage()) }
                1 -> diceRollingViewModel.diceRollingUI.secondDie.value?.let { image_view_dice_2.setImageResource(it.getImage()) }
                2 -> diceRollingViewModel.diceRollingUI.thirdDie.value?.let { image_view_dice_3.setImageResource(it.getImage()) }
                3 -> diceRollingViewModel.diceRollingUI.fourthDie.value?.let { image_view_dice_4.setImageResource(it.getImage()) }
                4 -> diceRollingViewModel.diceRollingUI.fifthDie.value?.let { image_view_dice_5.setImageResource(it.getImage()) }
                5 -> diceRollingViewModel.diceRollingUI.sixthDie.value?.let { image_view_dice_6.setImageResource(it.getImage()) }
            }
        }
    }
}