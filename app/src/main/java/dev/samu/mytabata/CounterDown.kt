package dev.samu.mytabata

import android.os.CountDownTimer
import android.util.Log

class CounterDown(var segundos: Int, var loquehacealhacertick: (Long) -> Unit) {
    private var counterState: Boolean = false
    private var remainingTime: Long = (segundos * 1000L)
    private var isStarted: Boolean = false

    private var myCounter: CountDownTimer? = null

    init {
        myCounter = object : CountDownTimer(remainingTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTime = millisUntilFinished
                if (counterState) loquehacealhacertick(millisUntilFinished / 1000)
            }

            override fun onFinish() {
                counterState = false
                isStarted = false
                remainingTime = 0
                Log.i("dam2", "mensajito")
            }
        }
    }

    fun toggle() {
        Log.i("dam2", "toggle: $counterState")
        if (this.counterState) {
            this.cancel()
        } else {
            if (!isStarted) {
                Log.i("dam2", "toggle: start")
                start()
                isStarted = true
            } else {
                resume()
            }
        }
    }

    fun start() {
        counterState = true
        myCounter?.start()
    }

    fun cancel() {
        counterState = false
        myCounter?.cancel()
    }

    fun resume() {
        counterState = true
        myCounter = object : CountDownTimer(remainingTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTime = millisUntilFinished
                if (counterState) loquehacealhacertick(millisUntilFinished / 1000)
            }

            override fun onFinish() {
                counterState = false
                isStarted = false
                remainingTime = 0
                Log.i("dam2", "mensajito")
            }
        }.start()
    }

    fun getFormattedTime(): String {
        val minutes = (remainingTime / 1000) / 60
        val seconds = (remainingTime / 1000) % 60
        return String.format("%02d:%02d", minutes, seconds)
    }
}
