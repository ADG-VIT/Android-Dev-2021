package com.example.task20

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
//    var day=0
//    var month=0
//    var year=0
//    var hour=0
//    var minute = 0
//    var savedday=0
//    var savedmonth=0
//    var savedyear=0
//    var savedhour=0
//    var savedminute = 0
//DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener --> have to add this in app compact activity
    var format =SimpleDateFormat("dd MMM,YYYY",Locale.US)
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        pickDate()

        val snackbar=findViewById<Button>(R.id.snackbar)
        val root_layout=findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.root_layout)
        alert.setOnClickListener {
            val builder= AlertDialog.Builder(this)
            val dialogView=layoutInflater.inflate(R.layout.alert,null)
            builder.setView(dialogView)
            builder.setCancelable(false)
            builder.setPositiveButton("Yes",DialogInterface.OnClickListener(){ dialogInterface: DialogInterface, i->
                finish()
            })
            builder.setNegativeButton("No",DialogInterface.OnClickListener(){ dialogInterface: DialogInterface, i->
                dialogInterface.cancel()
            })
            val alertDialog=builder.create()
            alertDialog.show()
        }
        toast.setOnClickListener {
            Toast.makeText(this,"Hola Amigo!",Toast.LENGTH_LONG).show()
        }
        val handler=Handler()
        progressbar.setOnClickListener{
            var pd =ProgressDialog(this)
            pd.setMessage("Welcome to the app user!")
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            pd.show()
            var handler=Handler()
            handler.postDelayed(object :Runnable{
                override fun run() {
                    pd.dismiss()
                }

            },5000)

        }



        Date.setOnClickListener {
            val now =Calendar.getInstance()
            val datepicker=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view,year,month,dayOfMonth->
                val selectDate=Calendar.getInstance()
                selectDate.set(Calendar.YEAR,year)
                selectDate.set(Calendar.MONTH,month)
                selectDate.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                val date =format.format(selectDate.time)
                Date.text="Date: $date"

            },
                now.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH))
            datepicker.show()

        }

        snackbar.setOnClickListener {
            val snackbar = Snackbar.make(root_layout,"Welcome to the app", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("Close", View.OnClickListener {
                snackbar.dismiss()
            })

            snackbar.setActionTextColor(ContextCompat.getColor(this,R.color.nayablue))
            snackbar.show()



        }
    }
    // This is for when we want date and time both

//    private fun getDateTimeCalender(){
//        val cal= Calendar.getInstance()
//        day=cal.get(Calendar.DAY_OF_MONTH)
//        month=cal.get(Calendar.MONTH)
//        year=cal.get(Calendar.YEAR)
//        hour =cal.get(Calendar.HOUR)
//        minute=cal.get(Calendar.MINUTE)
//    }
//    private fun pickDate(){
//
//        date.setOnClickListener {
//            getDateTimeCalender()
//            DatePickerDialog(this,this,year,month,day).show()
//        }
//
//    }
//
//    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
//        savedday=dayOfMonth
//        savedmonth=month
//        savedyear=year
//        getDateTimeCalender()
//        TimePickerDialog(this,this,hour, minute,true).show()
//    }
//
//    @SuppressLint("SetTextI18n")
//    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
//        savedminute=minute
//        savedhour=hourOfDay
//        date.text="$savedhour:$savedminute\n$savedday/$savedmonth/$savedyear"
//
//
//    }

}