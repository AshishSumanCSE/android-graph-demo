package com.example.androidgraph

fun <T> pairOf(
  first: T,
  second: T
): Pair<T, T> = Pair(first, second)

fun <T> tripleOf(
  first: T,
  second: T,
  third: T
): Triple<T, T, T> = Triple(first, second, third)
