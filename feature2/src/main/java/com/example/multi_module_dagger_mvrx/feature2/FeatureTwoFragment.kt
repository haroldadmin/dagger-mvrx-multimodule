package com.example.multi_module_dagger_mvrx.feature2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.postDelayed
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.example.multi_module_dagger_mvrx.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_feature_two.*

class FeatureTwoFragment : BaseFragment() {

    private val viewModel: FeatureTwoViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_feature_two, container, false)
        root.postDelayed(1000) {
            viewModel.greet("world")
        }
        return root
    }

    override fun invalidate() = withState(viewModel) { state ->
        message.text = state.greeting
    }

}