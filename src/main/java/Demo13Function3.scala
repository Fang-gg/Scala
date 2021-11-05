object Demo13Function3 {
  /**
   * 函数作为参数的应用
   */

  def main(args: Array[String]): Unit = {
    //定义一个数组
    val array: Array[Int] = Array[Int](1, 2, 3, 4, 5, 6, 7, 8)
    println(array)  // [I@129a8472 打印一个内存地址

    // 指定一个分隔符 将数组中的元素依次与分隔符拼接最后得到一个String
    // 同split函数相反
    println(array.mkString("|"))  // 1|2|3|4|5|6|7|8

    /**
     * 对array中的每个元素加1
     */

    /* scala中不支持这种for循环
//        scala中的for循环同python类似 只有 for each
//    for(int i =0;i<array.length;i++){
//
//      array(i) = array(i) +1
//    }
    */
    // Java思想
    var index = 0
    while (index < array.length) {
      array(index) = array(index) * 2
      // 没有 ++ --
      index += 1
    }
    println(array.mkString(","))

    // 以函数式编程的思想来做
    // map方法需要传入一个函数，会将array中的每个元素依次作为该函数的参数传入
    // 最后会得到一个新的array
    def add1(i: Int): Int = {
      i + 1
    }

    val mapArray: Array[Int] = array.map(add1)
    // 通过lambda表达式的方式
    val mapArray2: Array[Int] = array.map((i: Int) => i + 1)
    val mapArray3: Array[Int] = array.map(_ + 1)
    println(mapArray.mkString(","))
    println(mapArray2.mkString(","))
    println(mapArray3.mkString(","))

  }

}
