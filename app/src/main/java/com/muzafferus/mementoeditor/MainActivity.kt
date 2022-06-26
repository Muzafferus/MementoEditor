package com.muzafferus.mementoeditor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muzafferus.mementoeditor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var originator: Originator
    private lateinit var careTaker: CareTaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initMemento()
        setOnCLick()
    }

    private fun initMemento() {
        originator = Originator("")
        careTaker = CareTaker()
        careTaker.saveState(originator.createMemento())
    }

    private fun setOnCLick() {
        binding.imgUndo.setOnClickListener {
            originator.restore(careTaker.pop())
            binding.etMessage.setText(originator.state)

            binding.etMessage.setSelection(binding.etMessage.length())
        }

        binding.imgSave.setOnClickListener {
            originator.state = binding.etMessage.text.toString()
            careTaker.saveState(originator.createMemento())
        }
    }

}