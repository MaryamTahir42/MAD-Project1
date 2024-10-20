package com.example.uionlyapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // Variables for activity_login.xml
    private lateinit var editTextName: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var buttonNext: Button
    private lateinit var buttonSkip: Button
    private lateinit var textViewLogin: TextView
    private lateinit var textViewSignUp: TextView

    // Variables for activity_login2.xml
    private lateinit var buttonCorporateLogin: Button
    private lateinit var buttonInsuredLogin: Button

    // Variables for activity_dashboard.xml
    private lateinit var greetingText: TextView
    private lateinit var currentCityText: TextView
    private lateinit var searchBar: EditText
    private lateinit var referEarnLayout: LinearLayout
    private lateinit var referEarnText: TextView
    private lateinit var referEarnSubText: TextView
    private lateinit var orderMedicinesCard: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the initial view for the "Home" screen
        setContentView(R.layout.activity_login)
        setupLoginLayout()

        // Set up the BottomNavigationView for navigation
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    setContentView(R.layout.activity_login)
                    setupLoginLayout() // Reapply the home logic
                    true
                }
                R.id.navigation_pharmacy -> {
                    setContentView(R.layout.pharmacy)
                    setupPharmacyLayout()
                    true
                }
                else -> false
            }
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

        textViewLogin.setOnClickListener {
            Toast.makeText(this, "Navigating to Login", Toast.LENGTH_SHORT).show()
            setContentView(R.layout.activity_login2)
            setupLogin2Layout()
        }

        textViewSignUp.setOnClickListener {
            Toast.makeText(this, "Navigating to Dashboard", Toast.LENGTH_SHORT).show()
            setContentView(R.layout.activity_dashboard)
            setupDashboardLayout()
        }
    }

    // Function to handle the second layout (activity_login2.xml)
    private fun setupLogin2Layout() {
        buttonCorporateLogin = findViewById(R.id.buttonCorporateLogin)
        buttonInsuredLogin = findViewById(R.id.buttonInsuredLogin)

        buttonCorporateLogin.setOnClickListener {
            Toast.makeText(this, "Corporate Login", Toast.LENGTH_SHORT).show()
        }

        buttonInsuredLogin.setOnClickListener {
            Toast.makeText(this, "Insured Login", Toast.LENGTH_SHORT).show()
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

        greetingText.text = "Hello Maryam"
        currentCityText.text = "Current City: Lahore"

        referEarnLayout.setOnClickListener {
            Toast.makeText(this, "Refer & Earn Clicked", Toast.LENGTH_SHORT).show()
        }

        orderMedicinesCard.setOnClickListener {
            Toast.makeText(this, "Order Medicines Card Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    // Function to handle the pharmacy layout (pharmacy.xml)
    private fun setupPharmacyLayout() {
        // Handle pharmacy-specific actions here, such as setting up click listeners
        // and interacting with the UI components of pharmacy.xml.
        val searchBar = findViewById<EditText>(R.id.searchBar)
        searchBar.hint = "Search for Medicines"
    }
}
