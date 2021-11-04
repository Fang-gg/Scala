/**
 * Scala中的main方法只能放在object中运行
 * object 修饰的类 就相当于是静态类  也相当于代码加载到虚拟机中的"类对象"
 *                类中的方法及属性 相当于自动加上了static
 *                可以通过"类对象"(类名)直接进行调用
 *                单例模式
 */
object Demo2Scala {
  val i = 10
  /**
   * Scala中的main方法
   * 在scala中方法不可以用static修饰
   *
   *
   * def 定义一个函数的关键字
   * main 方法名
   * args: Array[String]  参数名:参数类型
   * Unit  返回值类型，相当于java中的void
   */
  def main(args: Array[String]): Unit = {
    println("Hello Scala")
    println(Demo2Scala.i)


    /**
     * 在Scala中使用Java中的类
     */
    val stu = new Demo3JavaStudent("001", "张三", 20)
    println(stu.id)
    println(stu.name)
    println(stu.getAge())
    println(stu)
    //使用Java中的打印方式，都是调用PrintStream中的println方法
    //底层是一样的，只不过Scala在上面做了封装让调用更简单
  }
}

