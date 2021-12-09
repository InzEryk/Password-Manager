package com.example.password_manager.ui.authenticationdatalist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.password_manager.R
import com.example.password_manager.data.local.db.entities.AuthenticationDataItem
import kotlinx.android.synthetic.main.authenticationdata_item.*
import kotlinx.android.synthetic.main.dialog_edit_authentication_data.*

class EditAuthenticationDataDialog(
    context: Context,
    var editDialogListener: EditDialogListener
): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.dialog_edit_authentication_data)

        tvAdd.setOnClickListener {

            val title = etTitleEdit.text.toString()
            val login = etLoginEdit.text.toString()
            val password = etPasswordEdit.text.toString()

            if(title.isEmpty() || login.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Please enter data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = AuthenticationDataItem(title, login, password)
            editDialogListener.onEditButtonClicked(item)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}