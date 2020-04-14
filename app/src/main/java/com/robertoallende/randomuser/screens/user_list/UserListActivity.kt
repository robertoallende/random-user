package com.robertoallende.randomuser.screens.user_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.robertoallende.randomuser.R
import kotlinx.android.synthetic.main.activity_user_list.*

class UserListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        setSupportActionBar(toolbar)
    }

}
