object Demo17Tuple {
  object Demo17Tuple {
    /**
     * 元素Tuple
     * 没有可变一说 元组就是不可变的
     * 虽然它不能通过index取元素 但它是有序的 可以通过_1 _2 _3 这样的方式取元素
     * 元素也可以重复
     * 元组最大的长度为22
     */
    def main(args: Array[String]): Unit = {
      val tuple1: Tuple1[Int] = Tuple1(1)
      val tuple2: (Int, Int) = Tuple2(1, 2) // 二元组
      val tuple3: (Int, Int, Int) = Tuple3(1, 2, 3) // 三元组

      val tuple5: (Int, Int, Int, Int, Int) = (1, 2, 3, 4, 5) // 自动根据元素的个数创建对应的元组
      // 取元素
      println(tuple5._1)
      println(tuple5._2)
      println(tuple5._3)
      println(tuple5._4)
      println(tuple5._5)

    }
  }
}
