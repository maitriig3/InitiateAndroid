package in_.mai3.initiateandroid.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import in_.mai3.initiateandroid.utils.logE

open class ViewBindingFragment<VB : ViewBinding>(private val bindingInflater: (layoutInflater: LayoutInflater) -> VB) :
    Fragment() {

    private lateinit var _binding: VB

    val binding: VB
        get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater.invoke(inflater)
        return _binding.root
    }

    protected fun contextNotNull(action: (Context) -> Unit) {
        try {
            if (isAdded && context != null) {
                action(requireContext())
            }
        } catch (e: Exception) {
            e.toString().logE("Context Null")
        }
    }

}