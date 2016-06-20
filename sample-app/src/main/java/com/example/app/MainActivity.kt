package com.example.app

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.setContentView

class MainActivity : Activity() {
    lateinit var ui: MainActivityUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        ui = MainActivityUI();
        ui.setContentView(this);

        ui.setKey(BuildConfig.CONSUMER_KEY);
        ui.setSecret(BuildConfig.CONSUMER_SECRET);
    }
}
