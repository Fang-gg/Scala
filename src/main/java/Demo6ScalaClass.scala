/**
 * 面向对象编程
 * 类中可以定义属性、方法、构造函数
 */


/**
 * {}就是scala中默认的构造函数
 * id:String,name:String,age:Int  构造函数的参数
 */
class Student(id: String, name: String, age: Int) {
  println("默认的构造函数")
  // 直接定义类的属性 通常会加一个_ 避免冲突
  val _id: String = id
  val _name: String = name
  val _age: Int = age
  var _clazz:String = _
  //重载构造方法  需要重新实现this方法
  // 第一行代码必须调用默认的构造方法
  def this(id: String, name: String, age: Int, clazz: String) {
    //调用默认的构造方法
    this(id,name,age)
    _clazz = clazz
  }

  //重写了父类的toString方法
  override def toString(): String = {
    //如果变量名以下划线开头  需要用花括号{}括起来
    // return 可以省略  最后一行代码默认是返回的值
    return s"Student(_id=${_id}, _name=${_name}, _age=${_age},_clazz=${_clazz})"
  }

  def printName(): Unit = {
    println(this._name)
  }
}

object Demo6ScalaClass {
  def main(args: Array[String]): Unit = {
    val stu: Student = new Student("001", "张三", 21)
    println(stu._id)
    println(stu._name)
    println(stu._age)
    stu.printName()
    println(stu)

    val stu1: Student = new Student("001", "张三", 21,clazz = "文科二班")
    println(stu1._id)
    println(stu1._name)
    println(stu1._age)
    println(stu1._clazz)

  }
}