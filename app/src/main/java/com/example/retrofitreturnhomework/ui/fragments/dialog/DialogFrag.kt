package com.example.retrofitreturnhomework.ui.fragments.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.retrofitreturnhomework.databinding.FragmentDialogBinding

class DialogFrag : DialogFragment() {

    lateinit var binding: FragmentDialogBinding

    private val args: DialogFragArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentDialogBinding.inflate(LayoutInflater.from(context))
        val dialog = AlertDialog.Builder(activity).
            setView(binding.root).
            create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        initialize()
        return dialog
    }

    private fun initialize() {
        getDataImage()
    }

    private fun getDataImage() {
        // приниматб данные через safeArgs
        Glide.with(binding.imageDialog).load(args.image).into(binding.imageDialog)
    }
}