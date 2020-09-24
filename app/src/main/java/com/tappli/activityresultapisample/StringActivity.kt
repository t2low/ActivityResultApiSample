package com.tappli.activityresultapisample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity

class StringActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, StringActivity::class.java)
        }
    }

    class GetString : ActivityResultContract<Unit, String?>() {
        override fun createIntent(context: Context, input: Unit?): Intent {
            return createIntent(context)
        }

        override fun parseResult(resultCode: Int, intent: Intent?): String? {
            return if (resultCode == RESULT_OK) {
                intent?.getStringExtra("Result")
            } else {
                null
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setResult(RESULT_OK, Intent().apply {
            putExtra("Result", "success")
        })
    }
}