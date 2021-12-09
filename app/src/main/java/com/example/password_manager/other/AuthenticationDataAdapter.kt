package com.example.password_manager.other

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.example.password_manager.R
import com.example.password_manager.data.local.db.entities.AuthenticationDataItem
import com.example.password_manager.ui.authenticationdatalist.AuthenticationDataViewModel
import com.example.password_manager.ui.authenticationdatalist.EditAuthenticationDataDialog
import com.example.password_manager.ui.authenticationdatalist.EditDialogListener
import kotlinx.android.synthetic.main.authenticationdata_item.view.*

class AuthenticationDataAdapter(
    private val context: Context,
    var items: List<AuthenticationDataItem>,
    private val viewModel: AuthenticationDataViewModel
): RecyclerView.Adapter<AuthenticationDataAdapter.AuthenticationDataViewHolder>() {

    inner class AuthenticationDataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AuthenticationDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.authenticationdata_item, parent, false)
        return AuthenticationDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: AuthenticationDataViewHolder, position: Int) {
        val currentAuthenticationDataItem = items[position]

        holder.itemView.tvTitle.text = currentAuthenticationDataItem.title

        holder.itemView.buttonLogin.setOnClickListener {
            val clipboardManager =
                context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clipData =
                ClipData.newPlainText("text", currentAuthenticationDataItem.login)
            clipboardManager.setPrimaryClip(clipData) 
            Toast.makeText(context, "You clicked on login", Toast.LENGTH_LONG).show()
        }

        holder.itemView.buttonPassword.setOnClickListener {
            val clipboardManager =
                context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clipData =
                ClipData.newPlainText("text", currentAuthenticationDataItem.password)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(context, "You clicked on password", Toast.LENGTH_LONG).show()
        }



        holder.itemView.ibMore.setOnClickListener {
            val popupMenu = PopupMenu(context, holder.itemView.ibMore)
            popupMenu.inflate(R.menu.options_menu)
            popupMenu.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                    R.id.delete -> {
                        viewModel.deleteAuthenticationDataItem(currentAuthenticationDataItem)
                        Toast.makeText(context, "Record deleted", Toast.LENGTH_SHORT).show()
                    }
                    R.id.edit -> {
                        EditAuthenticationDataDialog(context, object : EditDialogListener {
                            override fun onEditButtonClicked(authenticationDataItem: AuthenticationDataItem) {
                                viewModel.insertAuthenticationDataItem(authenticationDataItem)
                            }
                        }).show()
                        Toast.makeText(context, "Enter edit window", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
            popupMenu.show()
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}