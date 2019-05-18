package com.example.app.viewpage2slider

import android.media.Image
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var dotsCount: Int = 0
    private var dots: Array<ImageView?>? = null

    var imageSliderAdapter: ImageSliderAdapter? = null
    var colorList: MutableList<Int> = arrayListOf(android.R.color.holo_green_light,
            android.R.color.holo_blue_light, android.R.color.holo_purple,
            android.R.color.holo_red_light, android.R.color.holo_orange_light,
            android.R.color.black, android.R.color.darker_gray)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        imageSliderAdapter = ImageSliderAdapter(colorList)
        image_slider_pager.adapter = imageSliderAdapter
        image_slider_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                for (i in 0 until dotsCount) {
                    dots?.get(i)?.setImageDrawable(resources.getDrawable(R.drawable.nonselecteditem_dot))
                }
                dots?.get(position)?.setImageDrawable(resources.getDrawable(R.drawable.selecteditem_dot))
            }
        })

        setUiPageViewController(colorList)
    }


    private fun setUiPageViewController(imageList: MutableList<Int>) {
        dotsCount = imageList.size
        dots = arrayOfNulls(dotsCount)

        for (i in 0 until dotsCount) {
            dots!![i] = ImageView(this)
            dots!![i]?.setImageDrawable(resources.getDrawable(R.drawable.nonselecteditem_dot))

            val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )

            params.setMargins(4, 0, 4, 0)

            dots_indicator_linear_layout.addView(dots!![i], params)
        }

        dots!![0]?.setImageDrawable(resources.getDrawable(R.drawable.selecteditem_dot))
    }
}
