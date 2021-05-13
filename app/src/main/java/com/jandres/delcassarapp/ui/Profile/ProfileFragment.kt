package com.jandres.delcassarapp.ui.Profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jandres.delcassarapp.R
import com.jandres.delcassarapp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var profileBinding : FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileBinding = FragmentProfileBinding.inflate(inflater,container,false)

        return profileBinding.root
    }

}