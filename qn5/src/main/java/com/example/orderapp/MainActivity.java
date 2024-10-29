package com.example.orderapp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton radio15cm, radio30cm;
    CheckBox paneerCheckBox, mushroomCheckBox, onionCheckBox, jalapenoCheckBox;
    AutoCompleteTextView drinkAutoComplete;
    Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        radio15cm = findViewById(R.id.radio_15cm);
        radio30cm = findViewById(R.id.radio_30cm);
        paneerCheckBox = findViewById(R.id.paneerCheckBox);
        mushroomCheckBox = findViewById(R.id.mushroomCheckBox);
        onionCheckBox = findViewById(R.id.onionCheckBox);
        jalapenoCheckBox = findViewById(R.id.jalapenoCheckBox);
        drinkAutoComplete = findViewById(R.id.drinkAutoComplete);
        orderButton = findViewById(R.id.orderButton);

        // Set up AutoComplete for drink selection
        String[] drinks = {"Coke", "Pepsi", "Fanta"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, drinks);
        drinkAutoComplete.setAdapter(adapter);

        // Set OnClickListener for the order button
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal();
            }
        });
    }

    private void calculateTotal() {
        // Bread cost
        int breadCost = (radio15cm.isChecked()) ? 100 : 200;

        // Toppings cost
        int toppingsCost = 0;
        if (paneerCheckBox.isChecked()) toppingsCost += 50;
        if (mushroomCheckBox.isChecked()) toppingsCost += 50;
        if (onionCheckBox.isChecked()) toppingsCost += 30;
        if (jalapenoCheckBox.isChecked()) toppingsCost += 30;

        // Drink cost
        int drinkCost = 40; // Assuming any drink is Rs. 40

        // Calculate total
        int totalCost = breadCost + toppingsCost + drinkCost;

        // Display order summary in an alert dialog
        new AlertDialog.Builder(this)
                .setTitle("Order Summary")
                .setMessage("Total Cost: Rs. " + totalCost)
                .setPositiveButton("OK", null)
                .show();
    }
}
