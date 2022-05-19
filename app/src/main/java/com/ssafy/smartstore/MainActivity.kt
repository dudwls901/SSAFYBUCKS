package com.ssafy.smartstore

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.smartstore.databinding.ActivityHomeBinding
import com.ssafy.smartstore.databinding.ActivityMainBinding

data class Link<T> (var button: Button, var target: Class<T>)

private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")

        ActivityMainBinding.inflate(layoutInflater).run {
            setContentView(root)

            arrayOf (
                Link(btnJoin, JoinActivity::class.java),
                Link(btnLogin, LoginActivity::class.java),
                Link(btnMenuDetail, MainActivity::class.java),
                Link(btnMyPage, MainActivity::class.java),
                Link(btnOrder, OrderActivity::class.java),
                Link(btnOrderDetail, OrderDetailActivity::class.java),
                Link(btnShoppingList, ShoppingListActivity::class.java),
                Link(btnHome, HomeActivity::class.java)
            )
        }
            .forEach {
                Intent(this, it.target).apply {
                    it.button.setOnClickListener { _ -> startActivity(this) }
                }
            }
    }
}