package com.jandres.delcassarapp.ui.Products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jandres.delcassarapp.R
import com.jandres.delcassarapp.databinding.FragmentProductsBinding


class ProductsFragment : Fragment() {

    private lateinit var productsBinding: FragmentProductsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        productsBinding = FragmentProductsBinding.inflate(inflater,container,false)

        return productsBinding.root
    }

}