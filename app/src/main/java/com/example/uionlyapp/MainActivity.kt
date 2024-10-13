package com.example.uionlyapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Variables for the Login Layout (activity_login.xml)
    private lateinit var editTextName: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var buttonNext: Button
    private lateinit var buttonSkip: Button
    private lateinit var textViewLogin: TextView
    private lateinit var textViewSignUp: TextView

    // Variables for the Second Login Layout (activity_login2.xml)
    private lateinit var buttonCorporateLogin: Button
    private lateinit var buttonInsuredLogin: Button

    // Variables for the Dashboard Layout (activity_dashboard.xml)
    private lateinit var greetingText: TextView
    private lateinit var currentCityText: TextView
    private lateinit var searchBar: EditText
    private lateinit var referEarnLayout: LinearLayout
    private lateinit var referEarnText: TextView
    private lateinit var referEarnSubText: TextView
    private lateinit var orderMedicinesCard: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initially set the content to the login layout
        setContentView(R.layout.activity_login)

        // Initialize the views for the login screen
        setupLoginLayout()

        // Set up logic to switch between layouts if needed
        textViewLogin.setOnClickListener {
            Toast.makeText(this, "Navigating to Login", Toast.LENGTH_SHORT).show()
            // Switch to the second layout (activity_login2.xml)
            setContentView(R.layout.activity_login2)
            setupLogin2Layout()
        }

        textViewSignUp.setOnClickListener {
            Toast.makeText(this, "Navigating to Dashboard", Toast.LENGTH_SHORT).show()
            // Switch to the dashboard layout (activity_dashboard.xml)
            setContentView(R.layout.activity_dashboard)
            setupDashboardLayout()
        }
    }

    // Function to handle login layout (activity_login.xml)
    private fun setupLoginLayout() {
        editTextName = findViewById(R.id.editTextName)
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber)
        buttonNext = findViewById(R.id.buttonNext)
        buttonSkip = findViewById(R.id.buttonSkip)
        textViewLogin = findViewById(R.id.textViewLogin)
        textViewSignUp = findViewById(R.id.textViewSignUp)

        buttonNext.setOnClickListener {
            val name = editTextName.text.toString()
            val phoneNumber = editTextPhoneNumber.text.toString()

            if (name.isNotEmpty() && phoneNumber.isNotEmpty()) {
                Toast.makeText(this, "Proceeding with Next", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            }
        }

        buttonSkip.setOnClickListener {
            Toast.makeText(this, "Skipped account creation", Toast.LENGTH_SHORT).show()
        }
    }

    // Function to handle the second layout (activity_login2.xml)
    private fun setupLogin2Layout() {
        buttonCorporateLogin = findViewById(R.id.buttonCorporateLogin)
        buttonInsuredLogin = findViewById(R.id.buttonInsuredLogin)
        buttonNext = findViewById(R.id.buttonNext)
        buttonSkip = findViewById(R.id.buttonSkip)

        buttonCorporateLogin.setOnClickListener {
            Toast.makeText(this, "Corporate Login", Toast.LENGTH_SHORT).show()
        }

        buttonInsuredLogin.setOnClickListener {
            Toast.makeText(this, "Insured Login", Toast.LENGTH_SHORT).show()
        }

        buttonNext.setOnClickListener {
            Toast.makeText(this, "Proceeding with Next", Toast.LENGTH_SHORT).show()
        }

        buttonSkip.setOnClickListener {
            Toast.makeText(this, "Skipped", Toast.LENGTH_SHORT).show()
        }
    }

    // Function to handle the dashboard layout (activity_dashboard.xml)
    private fun setupDashboardLayout() {
        greetingText = findViewById(R.id.greetingText)
        currentCityText = findViewById(R.id.currentCityText)
        searchBar = findViewById(R.id.searchBar)
        referEarnLayout = findViewById(R.id.referEarnLayout)
        referEarnText = findViewById(R.id.referEarnText)
        referEarnSubText = findViewById(R.id.referEarnSubText)
        orderMedicinesCard = findViewById(R.id.orderMedicinesCard)

        // Set up greeting and current city text
        greetingText.text = "Hello Maryam"
        currentCityText.text = "Current City: Lahore"

        // Set up listeners for dashboard elements
        referEarnLayout.setOnClickListener {
            Toast.makeText(this, "Refer & Earn Clicked", Toast.LENGTH_SHORT).show()
        }

        orderMedicinesCard.setOnClickListener {
            Toast.makeText(this, "Order Medicines Card Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
