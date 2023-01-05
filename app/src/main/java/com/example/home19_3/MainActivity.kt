package com.example.home19_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.viewpager.widget.ViewPager
import com.example.home19_3.databinding.ActivityMainBinding
import com.example.home19_3.fragments.AddChancesFragment
import com.example.home19_3.fragments.GeoFragment
import com.example.home19_3.fragments.RightFragment
import com.example.home19_3.fragments.ServiceFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = MyAdapter(supportFragmentManager)
        adapter.addFragment(GeoFragment())
        adapter.addFragment(RightFragment())
        adapter.addFragment(ServiceFragment())
        adapter.addFragment(AddChancesFragment())
        binding.myViewPager.adapter = adapter
        binding.btnNext.setOnClickListener {
            binding.myViewPager.setCurrentItem(binding.myViewPager.currentItem + 1, true)
        }
        binding.btnClose.setOnClickListener {
            binding.myViewPager.setCurrentItem(binding.myViewPager.currentItem - 1, true)
        }
        binding.myViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                when (position) {
                    2 -> {
                        binding.btnNext.isVisible = true
                    }
                    3 -> {
                        binding.btnNext.isVisible = false
                    }
                }
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        binding.myCircleIndicatior.setViewPager(binding.myViewPager)

        setContentView(binding.root)
    }
}