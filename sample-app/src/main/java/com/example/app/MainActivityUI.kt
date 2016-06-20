package com.example.app

import android.widget.TextView
import org.jetbrains.anko.*

class MainActivityUI : AnkoComponent<MainActivity> {
    lateinit var keyView: TextView
    lateinit var secretView: TextView

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            keyView = textView("keyView") {
                lparams(width = matchParent, height = wrapContent)
            }


            secretView = textView("secretView") {
                lparams(width = matchParent, height = wrapContent)
            }
        }
    }

    fun setKey(key: String) {
        keyView.text = key;
    }

    fun setSecret(secret: String) {
        secretView.text = secret;
    }
}

