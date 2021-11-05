object Demo11Function1 {
  /**
   * 函数可以在哪里定义？
   * 类中、object中、
   */

  def fun(): Unit = {
    println("fun")
  }

  def main(args: Array[String]): Unit = {

    /**
     * def:定义函数的关键字
     * func:函数吗
     * Unit:返回值类型 相当于void
     * {}:函数体
     * 如果需要返回值时  最后一行代码会默认作为返回值
     */

    fun()

    def func1(): Unit = {
      println("func1")
    }

    func1()
    func2("你好")
    println(func3("10"))
    println(func4("10"))
    println(func5("10"))
    println(func6("10"))
    println(func7)
  }

  def func2(str: String): Unit = {
    println(str)
  }

  /**
   * 函数的省略
   * 1、return 关键字可以省略
   * 2、返回值类型可以省略  因为可以根据返回值进行推断
   * 3、如果只有一行代码  花括号可以省略
   * 4、如果函数没有参数  括号可以省略
   */
  def func3(str: String): Int = {
    return str.toInt + 100
  }

  //1、return 关键字可以省略
  def func4(str: String): Int = {
    str.toInt + 100
  }

  //2、返回值类型可以省略
  def func5(str: String)= {
    str.toInt + 100
  }

  //3、如果只有一行代码  花括号可以省略
  def func6(str: String) =
   str.toInt + 100

  //4、返回值类型可以省略
  def func7 = "Hello"  // 注意:这是一个函数，不是变量
}
