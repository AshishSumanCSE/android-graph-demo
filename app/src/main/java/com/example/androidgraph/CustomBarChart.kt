package com.example.androidgraph

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTTOM
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class CustomBarChart : BarChart {
  constructor(context: Context) : super(context)

  constructor(
    context: Context,
    attributeSet: AttributeSet
  ) : super(context, attributeSet)

  constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int
  ) : super(context, attrs, defStyleAttr)

  init {
    description.isEnabled = false
    legend.isEnabled = false
    setDrawMarkers(false)
    setTouchEnabled(false)
    xAxis.position = BOTTOM
    xAxis.setDrawGridLines(false)
    axisRight.setDrawLabels(false)
    axisRight.isEnabled = false
  }

  private val defaultColor = Color.GRAY

  fun submitData(
    data: List<Pair<String, Float>>,
    minValue: Float = data.map { it.second }
        .min() ?: 0f,
    maxValue: Float = data.map { it.second }
        .max() ?: 0f,
    lineColor: Int = defaultColor,
    barWidth: Float = 0.2f
  ) {

    val barEntries = data
        .mapIndexed { index, pair ->
          BarEntry(index.toFloat(), pair.second)
        }

    val barDataSet = BarDataSet(barEntries, "Label")
        .apply {
          color = lineColor
          setDrawValues(false)
        }


    setData(BarData(barDataSet).apply { this.barWidth = barWidth })
    renderer = RoundedBarChartRenderer(this, animator, viewPortHandler)
        .apply { setRadius(10f) }
    xAxis.valueFormatter = IndexAxisValueFormatter(data.map { it.first })
    axisLeft.axisMinimum = minValue
    axisLeft.axisMaximum = maxValue
    invalidate()
  }
}