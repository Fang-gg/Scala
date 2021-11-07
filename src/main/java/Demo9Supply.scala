object Demo9Supply {
  def main(args: Array[String]): Unit = {
    /**
     * Scala中的数据类型
     */

    var i: Int = 1
    //i变量的类型在该变量被创建的时候就固定了
    //不能随意赋值，只能赋同类型的值
    //i = 1.1

    //基本数据类型
    val byte: Byte = 1
    val short: Short = 1000
    val int: Int = 10000
    val long: Long = 10000000L
    val float: Float = 1.1f
    val double: Double = 1.1d
    val bool1: Boolean = true
    val bool2: Boolean = false
    val char: Char = 'c'

    //Any  好比Java中的Object
    //AnyRef  是所有引用类型的基类
    // AnyVal 是所有基本类型的基类

    val str : AnyRef = "abc"


    // 循环
    // 计算1~100的和
    var q = 1
    var sum = 0
    while (q <= 100) {
      sum += q
      q += 1
    }
    println(sum)
    // do while 循环体至少会被执行一次
    val x = 100
    val y = 200
    var x_y = 0
    do {
      x_y = x + y
    } while (x > y)
    println(x_y)

    // for 循环
    // 实际上scala中的for循环同Python类似 只有for each
    // Range函数
    // 计算1~100的和
    val list = new util.ArrayList[Int]()
    var sum2 = 0
    for (elem <- Range(1, 101, 1)) {
      sum2 += elem
    }
    println(sum2)

    // 计算1~100的和
    var sum3 = 0
    for (i <- 1 to 100) {
      sum3 += i
    }
    println(sum3)
    // 计算1~100的和
    var sum4 = 0
    for (i <- 1 until 101) {
      sum4 += i
    }
    println(sum4)
    // 计算1~100 奇数的和
    var sum5 = 0
    for (i <- 1 until 101 if i % 2 == 1) {
      sum5 += i
    }
    println(sum5)

    // 选择结构
    val age = 18
    if (age >= 18) {
      println("成年")
    } else if (age < 0) {
      println("年龄不规范")
    } else if (age < 18) {
      println("未成年")
    }else{
      println(".....")
    }



  }
}
