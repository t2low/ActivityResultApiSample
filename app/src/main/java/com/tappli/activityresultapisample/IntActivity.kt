package com.tappli.activityresultapisample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity

class IntActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, IntActivity::class.java)
        }
    }

    class GetInt : ActivityResultContract<Unit, Int>() {
        override fun createIntent(context: Context, input: Unit?): Intent {
            return createIntent(context)
        }

        override fun parseResult(resultCode: Int, intent: Intent?): Int {
            return if (resultCode == RESULT_OK) {
                intent?.getIntExtra("Result", 0) ?: 0
            } else {
                0
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setResult(RESULT_OK, Intent().apply {
            putExtra("Result", 999)
        })
    }
}

