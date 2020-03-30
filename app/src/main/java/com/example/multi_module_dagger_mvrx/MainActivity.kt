package com.example.multi_module_dagger_mvrx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multi_module_dagger_mvrx.feature1.FeatureOneFragment
import com.example.multi_module_dagger_mvrx.feature2.FeatureTwoFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btFeatureOne.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, FeatureOneFragment())
                .commit()
        }

        btFeatureTwo.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, FeatureTwoFragment())
                .commit()
        }
    }
}
