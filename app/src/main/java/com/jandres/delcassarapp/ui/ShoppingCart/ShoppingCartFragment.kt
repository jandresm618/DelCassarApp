package com.jandres.delcassarapp.ui.ShoppingCart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jandres.delcassarapp.R
import com.jandres.delcassarapp.databinding.FragmentShoppingCartBinding


class ShoppingCartFragment : Fragment() {

    private lateinit var carBinding : FragmentShoppingCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        carBinding = FragmentShoppingCartBinding.inflate(inflater,container,false)

        return carBinding.root
    }

}