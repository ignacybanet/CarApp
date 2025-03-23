package com.example.carapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var MyRadioGroup: RadioGroup = findViewById(R.id.wybor_samochodu)
        var RadioButtonCar: String = ""
        var MyImage: ImageView = findViewById(R.id.myImage)
        MyRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            val MyRadioButton: RadioButton = findViewById(checkedId)
            RadioButtonCar = "${MyRadioButton.text}"
            when(checkedId) {
                R.id.sedan -> MyImage.setImageResource(R.drawable.sedan)
                R.id.suv -> MyImage.setImageResource(R.drawable.suv)
                R.id.hatchback -> MyImage.setImageResource(R.drawable.hatchback)
            }
        }

        var klimatyzacja: CheckBox = findViewById(R.id.klimatyzacja)
        var wycieraczki: CheckBox = findViewById(R.id.wycieraczki)
        var kierownica: CheckBox = findViewById(R.id.kierownica)
        var klimatyzacjaValue: String = ""
        var wycieraczkiValue: String = ""
        var kierownicaValue: String = ""
        var MyButton: Button = findViewById(R.id.MyButton)
        MyButton.setOnClickListener {
            if(klimatyzacja.isChecked) {
                klimatyzacjaValue = "\nklimatyzacja"
            } else {klimatyzacjaValue = ""}


            if(wycieraczki.isChecked) {
                wycieraczkiValue = "\nwycieraczki"
            } else {wycieraczkiValue = ""}

            if(kierownica.isChecked) {
                kierownicaValue = "\nkierownica"
            } else {kierownicaValue = ""}

            if(RadioButtonCar.length == 0) RadioButtonCar = "???"

            findViewById<TextView>(R.id.podsumowanie).text = "Wybrałeś auto typu $RadioButtonCar \n Dodatkowe funkcje:  $klimatyzacjaValue  $wycieraczkiValue  $kierownicaValue"
        }
    }
}