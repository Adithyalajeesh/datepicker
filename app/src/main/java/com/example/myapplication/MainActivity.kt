package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.app.DatePickerDialog
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPickdate:Button= findViewById(R.id.buttonDate)
        val tvSelectedDate:TextView=findViewById(R.id.textDate)


        buttonPickdate.setOnClickListener(){showDatePickerDialog { year, month, day ->

            val selectedDate = "$day/${month + 1}/$year"
            tvSelectedDate.text = selectedDate



        }

    }
}

private  fun showDatePickerDialog(onDateSet: (year: Int, month: Int, day: Int) -> Unit) {
    var calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        this,
        { _, selectedYear, selectedMonth, selectedDay ->
            // Call the onDateSet callback with the selected date
            onDateSet(selectedYear, selectedMonth, selectedDay)
        },
        year, month, day
    )

    // Show the DatePickerDialog
    datePickerDialog.show()

}}