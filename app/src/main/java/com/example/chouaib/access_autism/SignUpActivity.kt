package com.example.chouaib.access_autism

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_sign_up.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import com.example.chouaib.access_autism.R.id.spinner


class SignUpActivity : AppCompatActivity() {

    // these must match the role names in the roles_array (values/roles)

    private val FAMILY_ROLE_STRING = "Family"
    private val CLINICIAN_ROLE_STRING = "Clinician"
    private val FACILITY_ROLE_STRING = "Facility"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val spinner = findViewById<Spinner>(R.id.spinnerRoles)

        val adapter = ArrayAdapter.createFromResource(this,
                R.array.roles_array, android.R.layout.simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
                if (spinner.selectedItem.toString() == FACILITY_ROLE_STRING) {
                    textViewErrorMessage.text = getString(R.string.missing_role_error_message)
                } else {
                    textViewErrorMessage.text = ""
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>) {
                textViewErrorMessage.text = ""
            }
        }
    }

    fun onClickConfirmSignUp(v: View){

        val spinner = findViewById<Spinner>(R.id.spinnerRoles)

        if (spinner.selectedItem.toString() == FAMILY_ROLE_STRING){
                val intent = Intent(this, FamilyCaregiverSignUpFormActivity::class.java)
                this.startActivity(intent)
        } else if (spinner.selectedItem.toString() == CLINICIAN_ROLE_STRING){
                val intent = Intent(this, ProviderSignUpFormActivity::class.java)
                this.startActivity(intent)
        }
        else {
                textViewErrorMessage.text = getString(R.string.missing_role_error_message)
        }
    }
}
