object Demo12Function2 {
  /**
   * 函数式编程(高阶函数)
   * 面向对象编程  把对象传来传去  对象作为参数传入时会有类型限制  对象作为返回值时也会有限制
   * 面下函数编程  把函数传来传去  函数作为参数传入时会有类型限制 函数作为返回值是也会有限制
   *
   * 函数式编程分为两类:
   * 1、以函数作为参数
   * 2、以函数作为返回值
   *
   *
   * 什么是函数的类型？
   * 跟def是无关的
   * 跟函数名是无关的
   * 跟参数名无关
   *
   * 函数的类型是由  参数的类型(类型、个数、顺序)以及返回值类型共同决定
   *
   */
  def main(args: Array[String]): Unit = {
    println(func1("10"))
    println(func2("10"))

    //调用funcX函数
    funcX(func1) //201
    funcX(func2) //202
    //    funcX(func3)  // 不符合funcX函数的定义


    // 使用lambda表达式
    funcX( (str: String) => {str.toInt + 1}) //201

    // lambda的简化
    // 1、如果代码只有一行 花括号可以省略
    // 2、参数的类型可以省略 括号也可以顺便省略
    // 3、如果参数只被调用了一次 则可以使用_下划线代替
    funcX((str: String) => str.toInt + 1) // 201
    funcX(str => str.toInt + 1) // 201
    funcX(_.toInt + 1) // 201
//    funcX(i) // 201
//    println(i("100")) // 101
  }


  // func1是一个（有一个参数，参数类型为String，返回值类型为Int）类型的函数
  def func1(str: String): Int = {
    str.toInt + 1
  }


  // func2是一个（有一个参数，参数类型为String，返回值类型为Int）类型的函数
  def func2(str: String): Int = {
    str.toInt + 2
  }

  // func3是一个（有一个参数，参数类型为Int，返回值类型为Int）类型的函数
  // func1和func2属于同类型的函数 func3不属于
  def func3(i: Int): Int = {
    i + 3
  }

  /**
   * f: String => Int
   * f: 是funcX函数所需要的参数的参数名  名字自定
   * String => Int  是funcX函数所需要的参数的类型(比较特殊，这里描述的是一个函数类型)
   * => 左边的部分 表示所传进来的函数  它的参数类型
   * => 右边的部分 表示所传进来的函数 它的返回值类型
   */

  // 定义了一个函数，它可以接受一个函数
  def funcX(f: String => Int): Unit = {
    val i: Int = f("200")
    println(i)
  }

  /**
   * lambda 表达式 匿名函数
   * 简化函数
   */

  // 定义一个lambda表达式
  // 定义了一个有两个参数 类型分别为String、Int
  //      返回值为Int这样一个匿名函数
  (str: String, i: Int) => {
    str.toInt + i
  }

  // 用lambda表达式简化func1的定义
  (str: String) => {
    str.toInt + 1
  }

  // 虽然是匿名函数 但也可以拥有名字
  val i: String => Int = (str: String) => str.toInt + 1
}
