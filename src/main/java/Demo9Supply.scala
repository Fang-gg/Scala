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


  }
}
