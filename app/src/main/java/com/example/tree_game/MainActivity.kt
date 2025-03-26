package com.example.tree_game

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
lateinit var button_lewy: Button
lateinit var button_prawy: Button
lateinit var button1: Button
lateinit var button2: Button
lateinit var button3: Button
lateinit var button4: Button
lateinit var button5: Button
lateinit var button6: Button
lateinit var button7: Button
lateinit var button8: Button
lateinit var operacja: Number;
lateinit var oczekiwana_liczba: Number;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button_lewy = findViewById(R.id.button_left);
        button_prawy = findViewById(R.id.button_right);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);

        /*TODO
        pobieranie oczekiwanej liczby z aktywnego przycisku


         */





        button_lewy.setOnClickListener {
            operacja = 0;
        }

        button_prawy.setOnClickListener {
            operacja = 1;
        }

    }
    fun random_move(arg1 : String){
        var zmienna: Number
        val rnds = (0..1).random()
        if(rnds == 0){
            zmienna = 0
        }
        else{
            zmienna = 1
        }

    }
}