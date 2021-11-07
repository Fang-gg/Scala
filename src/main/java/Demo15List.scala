import scala.collection.mutable.ListBuffer

object Demo15List {
  /**
   * List: 有序，元素不唯一，不可变的
   */

  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)
    println(list)
    // 常用的方法
    println(list.max) // 最大值
    println(list.min) // 最小值
    println(list.sum) // 求和
    println(list.size) // list的元素的个数
    println(list.sum / list.size.toFloat) // 计算平均值
    println(list.head) // 取第一个元素
    println(list.tail) // 取除第一个元素以外的所有的元素 并重新返回一个新的List
    println(list.reverse) // 倒转 并重新返回一个新的List
    println(list.mkString("|")) // 按照指定的分隔符将List中的每个元素依次拼接 返回一个字符串
    println(list.sorted) // 排序 并重新返回一个新的List
    println(list.isEmpty) // 判断List是否为空
    println("=" * 50)

    /**
     * map方法
     * 接收一个函数f：函数的参数类型为List中元素的类型，函数的返回值类型由自身决定
     * 会将List中的每个元素依次传给函数f
     * 最终会返回一个新的List
     */

    // 对每个元素做一个平方
    val listMap: List[Int] = list.map((i: Int) => i * i)
    println(listMap.mkString(","))
    println("=" * 50)

    /**
     * flatMap
     * 接收一个函数f：函数的参数类型为List中元素的类型，函数的返回值类型也由自身决定，但是必须是集合类的类型
     * 也会将List中的每个元素依次传递给函数f，并且会对函数f返回的结果进行扁平化（展开）处理
     */

    val words = List("java,scala,python", "hadoop,hive,hbase", "spark,flink,MapReduce")
    val wordsFlatMap: List[String] = words.flatMap((str: String) => str.split(","))
    println(wordsFlatMap.mkString(","))
    // Java打印集合的方式
    for (elem <- wordsFlatMap) {
      println(elem)
    }
    println("=" * 50)

    def printList(str: String) = {
      println(str)
    }


    // Scala中打印集合的方式
    /**
     * foreach方法
     * 也可以接收一个函数f：函数的参数类型为List中元素的类型 函数的返回值类型为Unit
     * 会将List中的每个元素依次传递给函数f
     * 它跟map函数最大的区别就是一个有返回值一个没有返回值
     */
    // 使用自定义函数printList
    wordsFlatMap.foreach(printList)
    println("=" * 50)
    // 直接传入系统的println函数
    /**
     * println(x: Any) 函数：
     * 参数类型为 Any
     * 返回值类型为 Unit
     * Any是所有任意的类型的基类
     */
    wordsFlatMap.foreach(println)

    /**
     * filter 过滤
     * 需要接收一个函数p: 函数的参数类型为List中元素的类型 返回值类型为Boolean
     * 会将List中的每个元素依次传递给函数p
     * 函数p 返回true则保留 返回false则过滤
     * 最终会返回一个新的List
     */
    // 将list中的奇数过滤出来
    val filterList: List[Int] = list.filter((i: Int) => {
      var flag = false
      if (i % 2 == 1) {
        //        return true // 不能直接使用return 不然会直接停止程序 后面所有的代码都会被跳过
        flag = true
      }
      flag
    })
    println(filterList.mkString(","))
    println(list.filter(_ % 2 == 1))

    // 直接对List中所有的元素进行从小到大排序 并返回一个新的List
    val sorted: List[Int] = list.sorted
    println(sorted.mkString(","))

    /**
     * sortBy 指定排序的列
     */
    val tupleList = List((1, 2), (3, 4), (2, 5), (6, 1))
    val sortByFirst: List[(Int, Int)] = tupleList.sortBy((tuple: (Int, Int)) => tuple._1)
    val sortBySecond: List[(Int, Int)] = tupleList.sortBy((tuple: (Int, Int)) => tuple._2)
    println(sortByFirst.mkString(","))
    println(sortBySecond.mkString(","))

    /**
     * sortWith 指定排序的规则
     */
    val sortWithList: List[Int] = list.sortWith((i1, i2) => {
      1 / i1.toFloat < 1 / i2.toFloat
    })

    println(sortWithList.mkString(","))

    /**
     * 可变的List
     */
    val lb: ListBuffer[Int] = ListBuffer(1, 2, 3, 4, 4, 5, 6, 7, 7, 1)
    println(lb.take(5)) // 取前N个元素
    // 增
    // append 可以传入n个与原List中元素类型相同的元素 并加入到List最后面
    // Int* 可变参数
    lb.append(4, 3, 2, 1)
    println(lb)
    lb.+=(11)
    println(lb)
    // 指定位置进行插入
    lb.insert(1, 11)
    println(lb)

    // 删
    lb.remove(1) // 删除指定位置的元素
    println(lb)
    lb.-=(6) // 删除指定的值
    println(lb)

    // 改
    lb(0) = 11
    println(lb)
    lb.update(1, 22)
    println(lb)



  }
}
