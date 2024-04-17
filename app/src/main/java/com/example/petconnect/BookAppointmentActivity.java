package com.example.petconnect;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {
    private EditText dateEditText;
    private Spinner clinicSpinner;
    private Spinner doctorSpinner;
    private Button scheduleButton;
    private int year, month, day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        dateEditText = findViewById(R.id.dateEditText);
        clinicSpinner = findViewById(R.id.clinicSpinner);
        doctorSpinner = findViewById(R.id.doctorSpinner);
        scheduleButton = findViewById(R.id.scheduleButton);

        // Initialize and populate the clinic spinner with dummy data
        initializeClinicSpinner();

        // Initialize and populate the doctor spinner with dummy data
        initializeDoctorSpinner();

        // Set a click listener for the "Schedule Appointment" button
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BookAppointmentActivity.this, "Appointment Scheduled", Toast.LENGTH_SHORT).show();
            }
        });

        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        // Get the current date and set it to the EditText
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        updateDateEditText();
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        year = selectedYear;
                        month = selectedMonth;
                        day = selectedDay;
                        updateDateEditText();
                    }
                }, year, month, day);

        datePickerDialog.show();
    }

    private void updateDateEditText() {
        // Update the EditText with the selected date
        String formattedDate = String.format("%02d/%02d/%02d", day, month + 1, year % 100);;
        dateEditText.setText(formattedDate);
    }


  

    private void initializeClinicSpinner() {
        // Dummy data for clinics
        String[] clinics = {"Clinic A", "Clinic B", "Clinic C", "Clinic D"};

        // Create an ArrayAdapter and set it to the clinic spinner
        ArrayAdapter<String> clinicAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, clinics);
        clinicAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clinicSpinner.setAdapter(clinicAdapter);
    }

    private void initializeDoctorSpinner() {
        // Dummy data for doctors
        String[] doctors = {"Doctor 1", "Doctor 2", "Doctor 3", "Doctor 4"};

        // Create an ArrayAdapter and set it to the doctor spinner
        ArrayAdapter<String> doctorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, doctors);
        doctorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        doctorSpinner.setAdapter(doctorAdapter);
    }

    

}