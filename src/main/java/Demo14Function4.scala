object Demo14Function4 {

  /**
   * 以函数作为返回值  也有类型的限制
   */
  def main(args: Array[String]): Unit = {
    // 分开来调用
    val stringToInt: String => Int = func1("100")
    val i: Int = stringToInt("200")
    println(i)

    // 直接一步调用 简化调用
    println(func1("100")("200"))
    println(func3("100", "200"))
    println(func4("100")("200"))

    println(func5(2, 16))
    println(func6(2))
    val f2: Int => Double = func7(3)
    println(f2(2))
    println(f2(3))
    println(f2(4))
  }

  // 在以函数作为返回值时 需要手动给定类型 自动推断会有问题
  // 定义了一个 以函数作为返回值的函数
  def func1(str1: String): String => Int = {

    def func2(str2: String): Int = {
      str1.toInt + str2.toInt
    }

    func2
  }

  // 普通的函数 可以接收两个参数
  def func3(str1: String, str2: String): Int = {
    str1.toInt + str2.toInt
  }

  // func1的简化
  // 函数柯里化：将一个有N个参数的函数 变成 N个只有一个参数的函数
  def func4(str1: String)(str2: String): Int = {
    str1.toInt + str2.toInt
  }

  /**
   * 计算a的b次方
   */
  def func5(a: Int, b: Int) = {
    // pow(a,b)方法支持传入两个参数
    // a的b次方
    Math.pow(a, b)
  }

  /**
   * 计算a的b次方 如果只传入a则计算a的3次方
   */
  // 第一种实现方式 使用默认参数
  // 偏函数 ：将一个含有N个参数的函数 变成含有N-X个参数的函数 X表示固定的参数
  def func6(a: Int, b: Int = 3) = {
    // pow(a,b)方法支持传入两个参数
    // a的b次方
    Math.pow(a, b)
  }

  // 第二种方式 使用函数式编程
  def func7(b: Int)(a: Int) = {
    // pow(a,b)方法支持传入两个参数
    // a的b次方
    Math.pow(a, b)
  }

}
