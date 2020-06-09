package com.example.androidgraph

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.db.williamchart.data.AxisType
import com.db.williamchart.data.Scale
import com.db.williamchart.view.ImplementsAlphaChart
import com.example.androidgraph.databinding.ActivityMainBinding

@ImplementsAlphaChart
class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


    initUi()
  }

  private fun initUi() {
    val donutData = listOf(13f)
    val data = linkedMapOf(
        "Jan" to 8F,
        "Feb" to 4F,
        "Mar" to 6F,
        "Apr" to 4F,
        "May" to 3F,
        "Jun" to 2F,
        "Jul" to 4F
    )

    binding.donutChart.apply {
      setBackgroundColor(Color.WHITE)
      donutTotal = 25f
      donutRoundCorners = true
      donutBackgroundColor = getColor(R.color.colorPrimaryLight)
      donutColors = intArrayOf(getColor(R.color.colorPrimaryDark))
      animate(donutData)
    }

    binding.lineChart.apply {
      smooth = true
      lineThickness = 10f
      lineColor = getColor(R.color.colorPrimaryDark)
      axis = AxisType.X
      labelsSize = 35f
      scale = Scale(0f, 10f)
      gradientFillColors = intArrayOf(getColor(R.color.colorPrimary), Color.WHITE)
      animate(data)
    }

    binding.barChart.apply {
      axis = AxisType.XY
      barRadius = 12f
      labelsSize = 35f
      labelsFormatter = { "${it.toInt()}" }
      scale = Scale(0f, 10f)
      spacing = 80f
      barsColor = getColor(R.color.colorPrimary)
      animate(data)
    }
  }
}