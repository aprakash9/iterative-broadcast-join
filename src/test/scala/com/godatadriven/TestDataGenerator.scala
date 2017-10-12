package com.godatadriven

import org.scalatest.FunSuiteLike


class TestDataGenerator extends FunSuiteLike {

  test("The generated sequence should be decreasing") {
    val listOfNumbers = DataGenerator
      .generateSkewedSequence(Math.pow(10, 6).toInt)
      .sortBy(_._1)
      .map(_._2)
    
    val listOfNumbersSorted = listOfNumbers.sorted.reverse

    val zipped = listOfNumbers.zip(listOfNumbersSorted)

    assert(zipped.forall(pair => pair._1 == pair._2))
  }

  test("The data should be skewed based on the key and count") {
    val key = 19
    val count = 25
    val res = DataGenerator.skewDistribution(key, count)

    assert(res.length == count)
    assert(res.forall(_ == key))
  }

}
