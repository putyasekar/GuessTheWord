package com.diki.idn.guesstheword.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private val _word = MutableLiveData<String>()
    private val _score = MutableLiveData<Int>()

    val score: LiveData<Int>
        get() = _score

    val word: LiveData<String>
        get() = _word

    override fun onCleared() {
        super.onCleared()
        Log.i("Game View Model", "Game View Model Destroyed")
    }

    private lateinit var wordList: MutableList<String>

    private fun refreshList() {
        wordList = mutableListOf(
            "apple",
            "dog",
            "cat",
            "food",
            "book",
            "pillow",
            "clothes",
            "country",
            "snack",
            "pencil",
            "dress",
            "toothbrush",
            "tooth",
            "plate",
            "fork",
            "jar",
            "laptop",
            "bed",
            "table",
            "cable",
            "snail",
            "soap",
            "bag"
        )
        wordList.shuffle()
    }

    init {
        _word.value = ""
        _score.value = 0
        Log.i("GameViewModel", "GameViewModel created!")
        refreshList()
        nextWord()
    }

    private fun nextWord() {
        if (wordList.isEmpty()) {
            onGameFinish()
        } else {
            //select and remove
            _word.value = wordList.removeAt(0)
        }
    }

    //method untuk update ui
    fun onSkip() {
        _score.value = (_score.value)?.minus(1)
        nextWord()
    }

    fun onCreate() {
        _score.value = (_score.value)?.plus(1)
        nextWord()
    }

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    //method untuk game completed
    fun onGameFinish() {
        _eventGameFinish.value = true
    }

    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }
}