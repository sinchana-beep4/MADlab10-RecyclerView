package com.example.madlab10_recyclerview

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize and set the Toolbar AFTER setContentView
        val toolbar = findViewById<Toolbar>(R.id.tool)
        setSupportActionBar(toolbar)

        val imag = findViewById<ImageView>(R.id.cookie)
        registerForContextMenu(imag)

        val but = findViewById<Button>(R.id.proceed)
        but.setOnClickListener {
            val pop = PopupMenu(this, but)
            pop.menuInflater.inflate(R.menu.popup, pop.menu)
            pop.setOnMenuItemClickListener { item ->
                when(item.itemId){
                    R.id.checkout -> Toast.makeText(this@MainActivity, "Happy shopping", Toast.LENGTH_SHORT).show()
                    R.id.ingredients -> Toast.makeText(this@MainActivity, "Recipe", Toast.LENGTH_SHORT).show()
                }
                true
            }
            pop.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                Toast.makeText(this, "Home!", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.shop -> {
                Toast.makeText(this, "Purchase what you love!", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.about -> {
                Toast.makeText(this, "Know about us!", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.contact_us -> {
                Toast.makeText(this, "Call us!", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shop -> Toast.makeText(this, "Shop!", Toast.LENGTH_SHORT).show()
            R.id.ing -> Toast.makeText(this, "Recipe", Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }

}


