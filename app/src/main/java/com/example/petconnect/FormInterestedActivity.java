package com.example.petconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FormInterestedActivity extends AppCompatActivity {

    EditText editName, editEmail, editPhone, editAddress, editReason, editMessage;
    CheckBox checkSpayNeuter, checkProperCare, checkReturnPet, checkFollowUpVisits;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_interested);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhone);
        editAddress = findViewById(R.id.editAddress);
        editReason = findViewById(R.id.editReason);
        editMessage = findViewById(R.id.editMessage);
        checkSpayNeuter = findViewById(R.id.checkSpayNeuter);
        checkProperCare = findViewById(R.id.checkProperCare);
        checkReturnPet = findViewById(R.id.checkReturnPet);
        checkFollowUpVisits = findViewById(R.id.checkFollowUpVisits);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editName.getText().toString();

                HashMap<String, Object> adoptionRequestData = new HashMap<>();

                adoptionRequestData.put("petName", getIntent().getStringExtra("PET_NAME"));
                adoptionRequestData.put("name", editName.getText().toString());
                adoptionRequestData.put("email", editEmail.getText().toString());
                adoptionRequestData.put("phone", editPhone.getText().toString());
                adoptionRequestData.put("address", editAddress.getText().toString());
                adoptionRequestData.put("reason", editReason.getText().toString());
                adoptionRequestData.put("message", editMessage.getText().toString());
                adoptionRequestData.put("spayNeuterChecked", checkSpayNeuter.isChecked());
                adoptionRequestData.put("properCareChecked", checkProperCare.isChecked());
                adoptionRequestData.put("returnPetChecked", checkReturnPet.isChecked());
                adoptionRequestData.put("followUpVisitsChecked", checkFollowUpVisits.isChecked());

                FirebaseDatabase database = FirebaseDatabase.getInstance();

                DatabaseReference reference = database.getReference("AdoptionRequest");

                String requestId = reference.push().getKey();
                reference.child(requestId).setValue(adoptionRequestData);

                Toast.makeText(FormInterestedActivity.this, "Form Sent Successfully",
                        Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });
    }
}