package com.monofix.mytriponair.extension

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.monofix.mytriponair.R


fun showOneButtonDialog(context: Context, title: String, desc: String, confirm: String, isCancellable: Boolean, confirmListener: ((dialog: DialogInterface) -> Unit)? = null) {
    val alert = AlertDialog.Builder(ContextThemeWrapper(context, R.style.Theme_AppCompat_Light_Dialog_Alert))
    alert.setTitle(title)
    alert.setMessage(desc)
    alert.setCancelable(isCancellable)
    alert.setPositiveButton(confirm) { dialog, _ ->
        confirmListener?.invoke(dialog)
    }
    alert.show()
}

fun showTwoButtonDialog(context: Context, title: String, desc: String, confirm: String, cancel: String, isCancellable: Boolean = false,
                        confirmListener: ((dialog: DialogInterface) -> Unit)? = null, cancelListener: ((dialog: DialogInterface) -> Unit)? = null) {
    val alert = AlertDialog.Builder(ContextThemeWrapper(context, R.style.Theme_AppCompat_Light_Dialog_Alert))
    alert.setTitle(title)
    alert.setMessage(desc)
    alert.setCancelable(isCancellable)
    alert.setPositiveButton(confirm) { dialog, _ ->
        confirmListener?.invoke(dialog)
    }
    alert.setNegativeButton(cancel) { dialog, _ ->
        cancelListener?.invoke(dialog)
    }
    alert.show()
}

fun showEventPopup(context: Context, imageURL: String?, imgWidth: Int, imgHeight: Int,
                   actionEvent: ((dialog: DialogInterface) -> Unit)? = null,
                   actionClose: ((dialog: DialogInterface) -> Unit)? = null,
                   actionCloseToday: ((dialog: DialogInterface) -> Unit)? = null): AlertDialog {

    val builder = AlertDialog.Builder(context, R.style.DialogStyle)
    val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_event, null)
    val dialog = builder.setView(dialogView).show()
    dialogView.apply {
        val container = findViewById<ConstraintLayout>(R.id.dialog_container)
        val imgEventPopup = findViewById<AppCompatImageView>(R.id.imgEventPopup)
        val screenWidth = Resources.getSystem().displayMetrics.widthPixels
        val dialogWidth = screenWidth - 40.dpToPx(context.resources.displayMetrics)
        val dialogHeight = dialogWidth * imgHeight / imgWidth

        imgEventPopup.layoutParams = imgEventPopup.layoutParams.apply {
            width = dialogWidth
            height = dialogHeight
        }
        imgEventPopup.loadURL(imageURL, 16)

        container.layoutParams = container.layoutParams.apply {
            width = dialogWidth
        }

        // Click Event
        imgEventPopup.setOnClickListener {
            actionEvent?.invoke(dialog)
        }
        findViewById<AppCompatImageView>(R.id.imgClose).setOnClickListener {
            actionClose?.invoke(dialog)
        }
        findViewById<AppCompatTextView>(R.id.textTodayClose).setOnClickListener {
            actionCloseToday?.invoke(dialog)
        }
        findViewById<AppCompatTextView>(R.id.textClose).setOnClickListener {
            actionClose?.invoke(dialog)
        }
    }
    return dialog
}

fun openNewTabWindow(context : Context, url: String?) {
    val uris = Uri.parse(url)
    val intents = Intent(Intent.ACTION_VIEW, uris)
    val bundle = Bundle()
    bundle.putBoolean("new_window", true)
    intents.putExtras(bundle)
    context.startActivity(intents)
}


