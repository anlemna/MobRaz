package com.example.zdorpit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "Завтрак", "Сырники без сахара -60г \nЙогурт -35г \nБанан", "К-371, Б-22,2, Ж-16,9, У-35,2"))
        items.add(Item(2, "Обед", "Бульон Чихиртма -500г \nКурица отварная -150г \nГречка отварная -100г \nСыр твёрдый -20г", "К-601, Б-34,2, Ж-25,9, У-40,2"))
        items.add(Item(3, "Ужин", "Тунец в собственном соку –100г \nЛистья салата -150г \nОгурец свежий \nЙогурт натуральный -50г", "К-371, Б-22,2, Ж-16,9, У-35,2"))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}