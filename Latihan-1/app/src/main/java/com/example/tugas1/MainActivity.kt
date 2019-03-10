package com.example.tugas1

import android.support.v7.app.AppCompatActivity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
private var Date = ""
private var Time = ""




class MainActivity : AppCompatActivity() {

  override fun onSaveInstanceState(outState: Bundle?) {
  if(outState!=null) {
    outState.putString(Date, pickDateBtn.text.toString())
    outState.putString(Time, pickTimeBtn.text.toString())
  }
  super.onSaveInstanceState(outState)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //Button Kalender
    pickDateBtn.setOnClickListener{

      //Kalender
      val kalender = Calendar.getInstance()
      val year = kalender.get(Calendar.YEAR)
      val month = kalender.get(Calendar.MONTH)
      val day = kalender.get(Calendar.DAY_OF_MONTH)

      val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view: DatePicker, mYear: Int, mMonth: Int, mDay: Int ->
        pickDateBtn.setText("" + mDay + "/" + mMonth + "/" + mYear)
      }, year, month, day)

      //Show Dialog
      dpd.show()
    }

    //Button Time
    pickTimeBtn.setOnClickListener{
      val cal = Calendar.getInstance()
      val timeSetListener = TimePickerDialog.OnTimeSetListener{timePicker, hour :Int, minute :Int ->
          cal.set(Calendar.HOUR_OF_DAY, hour)
          cal.set(Calendar.MINUTE, minute)
          pickTimeBtn.text = SimpleDateFormat("HH:mm").format(cal.time)
        }
        TimePickerDialog(this,timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false).show()
      }


      submit.setOnClickListener {
        Date = pickDateBtn.text.toString()
        Time = pickTimeBtn.text.toString()
      }

    if(savedInstanceState!=null){
      pickDateBtn.text=savedInstanceState.getString(Date)
      pickTimeBtn.text=savedInstanceState.getString(Time)
    }
  }
}
