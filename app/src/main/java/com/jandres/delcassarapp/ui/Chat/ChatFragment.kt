package com.jandres.delcassarapp.ui.Chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jandres.delcassarapp.R
import com.jandres.delcassarapp.databinding.FragmentChatBinding


class ChatFragment : Fragment() {

    private lateinit var chatBinding: FragmentChatBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        chatBinding = FragmentChatBinding.inflate(inflater,container,false)

        return chatBinding.root
    }

}