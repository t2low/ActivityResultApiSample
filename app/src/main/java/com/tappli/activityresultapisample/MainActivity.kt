package com.tappli.activityresultapisample

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        Toast.makeText(this, uri?.toString() ?: "cancelled", Toast.LENGTH_SHORT).show()
    }

    private val getActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val string = result.data?.getStringExtra("Result") ?: "empty"
            Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectButton.setOnClickListener {
            getContent.launch("image/*")
        }

        getResultButton.setOnClickListener {
            val intent = StringActivity.createIntent(this)
            getActivityResult.launch(intent)
        }
    }
}