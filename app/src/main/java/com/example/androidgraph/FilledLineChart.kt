package com.example.androidgraph

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTTOM
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class FilledLineChart : LineChart {
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
    xAxis.setAvoidFirstLastClipping(true)
    axisRight.setDrawLabels(false)
    axisRight.isEnabled = false
    axisLeft.setDrawGridLines(false)
  }

  private val defaultColor = Color.GRAY

  fun submitData(
    data: List<Pair<String, Float>>,
    minValue: Float = data.map { it.second }.min() ?: 0f,
    maxValue: Float = data.map { it.second }.max() ?: 0f,
    fillColor: Int = defaultColor
  ) {
    if(data.isEmpty()) return
    val lineEntries = data
        .mapIndexed { index, pair ->
          Entry(index.toFloat(), pair.second)
        }

    val lineDataSet = LineDataSet(lineEntries, null)
        .apply {
          color = fillColor
          setDrawCircles(false)
          setDrawValues(false)
          setDrawFilled(true)
          this.fillColor = fillColor
          fillAlpha = 255
        }
    setData(LineData(lineDataSet))
    xAxis.valueFormatter = IndexAxisValueFormatter(data.map { it.first })
    axisLeft.axisMinimum = minValue
    axisLeft.axisMaximum = maxValue
    animateY(1000)
    invalidate()
  }
}