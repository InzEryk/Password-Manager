package com.example.password_manager.ui.authenticationdatalist

import com.example.password_manager.data.local.db.entities.AuthenticationDataItem

interface EditDialogListener {

    fun onEditButtonClicked(authenticationDataItem: AuthenticationDataItem)
}