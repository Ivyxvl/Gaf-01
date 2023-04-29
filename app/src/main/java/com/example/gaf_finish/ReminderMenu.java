package com.example.gaf_finish;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class ReminderMenu extends AppCompatActivity {
    private ImageView toHome;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    Button timeButton;
    int hour, minute;
    String[] petsNameArr = {"Ketty", "Leo", "John", "Mello"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    private RadioGroup radioGroup;
    EditText shortMessage;
    private String message;
    private Button set;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remindermenu);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
       dateButton.setText(getTodaysDate());

        timeButton = findViewById(R.id.timeButton);

        toHome = findViewById(R.id.backToHome);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReminderFirst();
            }

            public void openReminderFirst() {
                Intent intent = new Intent(ReminderMenu.this, Reminder_first.class);
                startActivity(intent);
            }
        });

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(this, R.layout.text_item, petsNameArr);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String item = parent.getItemAtPosition(i).toString();

            }
        });

        radioGroup = findViewById(R.id.radio_name_group);
        /*radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_item_a:
                        Toast.makeText(ReminderMenu.this, "Daily reminder is selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_item_b:
                        Toast.makeText(ReminderMenu.this, "Weekly reminder is selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_item_c:
                        Toast.makeText(ReminderMenu.this, "Monthly reminder is selected", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });*/

        shortMessage = (EditText) findViewById(R.id.shortMessage);
        shortMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = shortMessage.getText().toString();
               // showShortMessageToast(message);
            }
        });
        set = findViewById(R.id.setButton);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSetMessageToast("The reminder is on");
            }
        });
    }

    private void showShortMessageToast(String text){
        Toast.makeText(ReminderMenu.this, text + " is settled", Toast.LENGTH_SHORT).show();
    }

    private void showSetMessageToast(String text){
        Toast.makeText(ReminderMenu.this, text, Toast.LENGTH_SHORT).show();
    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker() {

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = makeDateString(dayOfMonth, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);


    }

    private String makeDateString(int dayOfMonth, int month, int year) {
        return getMonthFormat(month) + " " + dayOfMonth + " " + year;
    }

    private String getMonthFormat(int month) {
        if (month == 1) {
            return "JAN";
        }
        if (month == 2) {
            return "FEB";
        }
        if (month == 3) {
            return "MAR";
        }
        if (month == 4) {
            return "APR";
        }
        if (month == 5) {
            return "MAY";
        }
        if (month == 6) {
            return "JUN";
        }
        if (month == 7) {
            return "JUL";
        }
        if (month == 8) {
            return "AUG";
        }
        if (month == 9) {
            return "SEP";
        }
        if (month == 10) {
            return "OCT";
        }
        if (month == 11) {
            return "NOV";
        }
        if (month == 12) {
            return "DEC";
        }
        return "JAN";
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }

    public void popTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

}