package com.example.multi_module_dagger_mvrx.feature1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.postDelayed
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.example.multi_module_dagger_mvrx.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_feature_one.*

class FeatureOneFragment : BaseFragment() {

    private val viewModel: FeatureOneViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_feature_one, container, false)
        root.postDelayed(1000) {
            viewModel.greet("world")
        }
        return root
    }

    override fun invalidate() = withState(viewModel) { state ->
        message.text = state.greeting
    }

}