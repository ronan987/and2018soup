package com.example.ronald.soupapps

import android.databinding.DataBindingUtil
import android.databinding.ObservableBoolean
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ronald.soupapps.databinding.ActivityMainBinding
import com.example.ronald.soupapps.models.Book
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val loading: ObservableBoolean = ObservableBoolean(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.loading = loading
    }

    fun loadBook() {
        thread {
            Thread.sleep(3000)
            runOnUiThread {
                binding.book = buildBook()
                loading.set(false)

            }
        }
    }

    fun buildBook(): Book = Book().apply {
        name = "Natilla"
        img = "https://www.elespectador.com/sites/default/files/cromos/image_main/apert_1.jpg"
        date = Date()
        category = 1
    }

}
