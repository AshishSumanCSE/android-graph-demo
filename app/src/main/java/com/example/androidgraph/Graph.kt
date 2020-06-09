package com.example.androidgraph

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.db.williamchart.data.AxisType
import com.db.williamchart.data.Scale
import com.db.williamchart.view.BarChartView
import com.db.williamchart.view.DonutChartView
import com.db.williamchart.view.HorizontalBarChartView
import com.db.williamchart.view.ImplementsAlphaChart
import com.db.williamchart.view.LineChartView

object Graph {
  enum class GraphType {
    LineGraph,
    BarGraph,
    HorizontalGraph,
    RadialGraph
  }

  @ImplementsAlphaChart
  fun create(
    context: Context,
    graphType: GraphType,
    data: List<GraphData>,
    maxValue: Float,
    animate: Boolean = true
  ): View {
    return when (graphType) {
      GraphType.LineGraph -> LineChartView(context).apply {
        layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            context.resources.getDimension(R.dimen.dimen_200dp).toInt()
        )
        smooth = true
        lineThickness = 10f
        lineColor = context.getColor(R.color.colorPrimaryDark)
        axis = AxisType.X
        labelsSize = 35f
        scale = Scale(0f, maxValue)
        if (animate) animate(data.toLinkedHashMap()) else show(data.toLinkedHashMap())
      }
      GraphType.BarGraph -> BarChartView(context).apply {

      }
      GraphType.HorizontalGraph -> HorizontalBarChartView(context).apply {

      }
      GraphType.RadialGraph -> DonutChartView(context).apply {

      }
    }
  }
}

data class GraphData(
  val value: Float,
  val label: String
)

fun List<GraphData>.toLinkedHashMap(): LinkedHashMap<String, Float> {
  val linkedHashMap = linkedMapOf<String, Float>()
  this.forEach {
    linkedHashMap[it.label] = it.value
  }
  return linkedHashMap
}
