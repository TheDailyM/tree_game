package com.example.tree_game

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginTop

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
lateinit var operacja: Number
var oczekiwana_liczba: Int = TODO()
var current_tree_segment: Button
var tree_zmienna: Int = 0;
val tree_tablica = arrayOf(button1, button2, button3, button4, button5, button6, button7, button8)

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

        button_lewy = findViewById(R.id.button_left)
        button_prawy = findViewById(R.id.button_right)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)

        //val tree_tablica = arrayOf(button1, button2, button3, button4, button5, button6, button7, button8)

        current_tree_segment = tree_tablica[tree_zmienna];

        /*TODO
        pobieranie oczekiwanej liczby z aktywnego przycisku


         */





        button_lewy.setOnClickListener {
            operacja = 0
            odp(current_tree_segment)
            if (operacja != oczekiwana_liczba){
                System.exit(0);
            }
            move()
            next_tree_segment()
        }

        button_prawy.setOnClickListener {
            operacja = 1
            odp(current_tree_segment)
            if (operacja != oczekiwana_liczba){
                System.exit(0);
            }
            move()
            next_tree_segment()
        }

    }

    //FUNKCJE:
    //PRZYPISUJE RANDOMOWY TEXT DO KOLEJNYCH BLOKÓW - NIESKOŃCZONE
    fun random_move(arg1 : Button){
        val rnds = (0..1).random()
        if(rnds == 0){
            arg1.text = "&lt;&lt;"
        }
        else{
            arg1.text = "&gt;&gt;"
        }

    }
    //OCZEKIWANY INPUT
    fun odp(arg1: Button){
        if (arg1.text == "&lt;&lt;"){
            oczekiwana_liczba == 0
        }
        else {
            oczekiwana_liczba == 1
        }
    }
    //PRZESÓWANIE AKTYWNEGO BLOKU
    fun next_tree_segment(){
        if (tree_zmienna > 8){
            tree_zmienna++
        }
        else{
            tree_zmienna =0
        }
        current_tree_segment = tree_tablica[tree_zmienna]
    }
    fun move(){
        //button1
        for (i in 0..7){
            var param = tree_tablica[i].layoutParams as ViewGroup.MarginLayoutParams
            if (tree_tablica[i].marginTop > 610){
                param.setMargins(0,-201,0,0)
                random_move(tree_tablica[i])
            }else{
                param.setMargins(0,tree_tablica[i].marginTop + 116,0,0)
            }
            tree_tablica[i].layoutParams = param
        }
    }
}