package ch1intro

import scala.collection.mutable.ArrayBuffer

object ArraysPlay extends App {

//  String[] arr = new String[3];
//  var arr:Array[String] = new Array(3);

//  String[] arr = {"a","b","c"};
  var arr = Array("a","b","c")

  arr(0) = "a"
  arr(1) = "b"

//  arr(3) = "bum"

  println(arr(0))
  println(arr.mkString(",")) // collect(joining(","))

  var a = new Apelabila
  var trei = a(2)
  println(trei)

  a(4) = "patru"

  // TODO println "Echo"

  // unde-i aray listu ?!!!
  var arrayList = new ArrayBuffer[String] // ~~ArrayList
  println("initial : " + arrayList.size)
  arrayList += "a"
  println(arrayList)

}

class Apelabila {
  def apply(i:Int): String = (i+1).toString
  def update(i:Int, s:String):Unit = {
    println(
      s"""Setez pe indexul $i
         asdsa

         valoarea $s""")
  }
}