package in_.mai3.initiateandroidsample.ui

import android.os.Bundle
import android.view.View
import in_.mai3.initiateandroid.ui.fragment.ViewBindingFragment
import in_.mai3.initiateandroidsample.databinding.FragmentSampleBinding


class SampleFragment : ViewBindingFragment<FragmentSampleBinding>(FragmentSampleBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}