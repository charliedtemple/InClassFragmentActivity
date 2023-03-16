package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        // Attach an instance of ImageDisplayFragment using factory method
        var imageDisplayFragment = ImageDisplayFragment.newInstance(imageArray)
        val fragmentContainerView = findViewById<FragmentContainerView>(R.id.fragmentContainerView)
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, imageDisplayFragment).commit()

    }
}