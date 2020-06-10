package com.example.androidgraph

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androidgraph.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    initUi()
  }

  private fun initUi() {
    val data = linkedMapOf(
        "Jan" to 8F,
        "Feb" to 4F,
        "Mar" to 6F,
        "Apr" to 4F,
        "May" to 3F,
        "Jun" to 2F,
        "Jul" to 4F
    ).toList()
    val minValue = 0f
    val maxValue = 10f

    binding.radialChart.submitData(
        tripleOf(30, 40, 50),
        getColor(R.color.colorPrimaryDark),
        getColor(R.color.colorPrimaryVeryLight)
    )

    binding.lineChart.submitData(data, minValue, maxValue, getColor(R.color.colorPrimaryLight))

    binding.smoothLineChart.submitData(
        data, minValue, maxValue, getColor(R.color.colorPrimaryLight)
    )

    binding.barChart.submitData(
        data, minValue, maxValue, getColor(R.color.colorPrimaryLight)
    )

  }

}