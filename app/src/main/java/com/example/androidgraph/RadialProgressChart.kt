package com.example.androidgraph

import android.graphics.Color
import com.mindorks.RadialProgressBar


fun RadialProgressBar.submitData(
  data: Triple<Int, Int, Int>,
  progressColor: Int = Color.GRAY,
  emptyProgressColor: Int = Color.TRANSPARENT
) {
  setProgressValues(data.first, data.second, data.third)
  hasEmptyProgressBar(true)
  setProgressColor(progressColor)
  setEmptyProgressColor(emptyProgressColor)
  setAnimationInProgressView(true)
}

fun RadialProgressBar.setProgressColor(
  progressColor: Int
) {
  setInnerProgressColor(arrayListOf(progressColor))
  setCenterProgressColor(arrayListOf(progressColor))
  setOuterProgressColor(arrayListOf(progressColor))
}

fun RadialProgressBar.setEmptyProgressColor(
  emptyProgressColor: Int
) {
  setEmptyProgressColorInnerView(emptyProgressColor)
  setEmptyProgressColorCenterView(emptyProgressColor)
  setEmptyProgressColorOuterView(emptyProgressColor)
}