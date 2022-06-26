package com.muzafferus.mementoeditor

data class Memento(val state: String)

class Originator(var state: String) {

    fun createMemento(): Memento {
        return Memento(state)
    }

    fun restore(memento: Memento) {
        state = memento.state
    }
}

class CareTaker {
    private val mementoList = ArrayList<Memento>()

    fun saveState(state: Memento) {
        mementoList.add(state)
    }

    fun pop(): Memento {
        if (mementoList.size > 0) {
            mementoList.remove(mementoList[mementoList.lastIndex])
        }

        if (mementoList.lastIndex < 0) {
            return Memento("")
        }
        return mementoList[mementoList.lastIndex]
    }
}
