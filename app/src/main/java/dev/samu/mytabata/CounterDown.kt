package dev.samu.mytabata

import android.os.CountDownTimer

class CounterDown(var segundos: Int, val onCounterTick: (Long) -> Unit) {
    var myCounter: CountDownTimer
    var counterState: Boolean = false

    init {
        myCounter = object : CountDownTimer((segundos * 1000L), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                onCounterTick(millisUntilFinished / 1000)
            }

            override fun onFinish() {
                counterState = false
            }
        }
    }
}
