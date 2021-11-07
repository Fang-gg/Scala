object Demo21Match {
  /**
   * 模式匹配 相当于Java中的 switch case
   * Java中的模式匹配可以匹配 基本数据类型的值、字符串、枚举
   * Scala中的模式匹配可以匹配 基本数据类型的值、字符串、枚举、类型、对象
   */


  def main(args: Array[String]): Unit = {
    // 1、匹配基本数据类型的值
    val i: Int = 4

    i match {
      case 1 => println(s"i的值是1")
      case 2 => println(s"i的值是2")
      case 3 => println(s"i的值是3")
      case _ => println("其他的值")
    }

    // 2、匹配字符串
    val str: String = "abc"
    str match {
      case "abc" => {
        val upperStr: String = "abc".toUpperCase()
        println(upperStr)
      }
      case "efg" => println("efg")
      case _ => println("未匹配到")
    }

    // 4、匹配类型
    val s: Any = 1.1
    s match {
      case m: Int => println(s"变量s的类型为Int，它的值为${m}")
      case m: Float => println(s"变量s的类型为Float，它的值为${m}")
      case m: Double => println(s"变量s的类型为Double，它的值为${m}")
      case m: String => println(s"变量s的类型为String，它的值为${m}")
      case _ => println("其他情况")
    }

    // 5、匹配样例类的对象
    val zs: StuMatch = StuMatch("001", "张三", 21)

    zs match {
      case StuMatch("001", "张三", 20) => println("它是张三")
      case StuMatch("001", "张三", 21) => println("它是假的张三")
      case _ => println("无法判断")
    }

    // 模式匹配在Map中的运用
    /**
     * Option : 有的时候在写函数时，有时会返回一个具体的值，有时又没有
     * 如果直接就返回null，那么对于调用者来说 不小心就会发生空指针异常
     * 总共就两种情况 对应两种取值
     * 如果有 就会返回 Some
     * 没有 就返回None
     */
    val map: Map[String, String] = Map("k1" -> "v1", "k2" -> "v2")

    val option: Option[String] = map.get("k2")

    option match {
      case Some(v) => println(s"key存在 对应的value是${v}")
      case None => println("key不存在，取不到value")
    }

    // 模式匹配还可以有返回值
    val value: Any = option match {
      case Some(v) => v
      case None => 0
    }
    println(value)
    // 上面的代码就相当于
    val v: Any = map.getOrElse("k2", 0)
    println(v)

  }

  case class StuMatch(id: String, name: String, age: Int)


}
