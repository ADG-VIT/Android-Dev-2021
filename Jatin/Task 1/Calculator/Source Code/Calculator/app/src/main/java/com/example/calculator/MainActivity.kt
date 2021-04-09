package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buNumberEvent (view:View){
        if (isNewOP){
            eShowText.setText("")
        }
        isNewOP=false
        val BuSelect = view as Button
        var BuGetValue:String=eShowText.text.toString()
        when(BuSelect.id){
             bu0.id-> {
                 BuGetValue += "0"
             }
            bu1.id->{
               BuGetValue += "1"
            }
            bu2.id->{
                BuGetValue += "2"
            }
            bu3.id->{
                BuGetValue += "3"
            }
            bu4.id->{
                BuGetValue += "4"
            }
            bu5.id->{
                BuGetValue += "5"
            }
            bu6.id->{
                BuGetValue += "6"
            }
            bu7.id->{
                BuGetValue += "7"
            }
            bu8.id->{
                BuGetValue += "8"
            }
            bu9.id->{
                BuGetValue += "9"
            }
            buMultiOperation.id->{
                BuGetValue = "-"+ BuGetValue
            }



        }
        eShowText.setText(BuGetValue)

    }
var op ="*"
var oldnumber= ""
var isNewOP=true
    fun buOpEvent(view: View){
        var buSelect = view as Button
        when(buSelect.id){
            buMultiply.id->{
                op="*"
            }
            buDivide.id->{
                op="/"
            }
            buAdd.id->{
                op="+"
            }
            buSubtract.id->{
                op="-"
            }
            buPercentage.id->{
                op="%"
            }
        }
        oldnumber= eShowText.text.toString()
        isNewOP=true

    }
    fun buEqual(view:View){
        var newNumber= eShowText.text.toString()
        var finalNumber:Double? =null
        when(op){
            "*"->{
                finalNumber = oldnumber.toDouble() *newNumber.toDouble()
            }
            "+"->{
                finalNumber = oldnumber.toDouble() +newNumber.toDouble()
            }
            "-"->{
                finalNumber = oldnumber.toDouble() -newNumber.toDouble()
            }
            "/"->{
                finalNumber = oldnumber.toDouble() /newNumber.toDouble()
            }

        }
        eShowText.setText(finalNumber.toString())
        isNewOP=true

    }
    fun buPercent(view: View){
        var number = eShowText.text.toString().toDouble()/100
        eShowText.setText(number.toString())
        isNewOP=true
    }
    fun buAc(view: View){
        eShowText.setText("0")
        isNewOP = true
    }
}


