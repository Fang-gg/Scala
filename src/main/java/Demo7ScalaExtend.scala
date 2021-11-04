

object Demo7ScalaExtend {
  def main(args: Array[String]): Unit = {
    val b: A = new B("001", "李四", 22)
    println(b.toString)
  }
}


class A(id: String, name: String) {
  println("A的构造方法")
  //定义即赋值
  val _id: String = id
  val _name: String = name


  override def toString = s"A(_id=${_id}, _name=${_name})"
}

/**
 * 继承还是使用extends关键字
 * 但是在继承的时候需要调用父类的构造方法
 */
class B(id: String, name: String, age: Int) extends A(id, name) {

  val _age: Int = age
  println("B的构造方法")

  override def toString = s"A(_id=${_id}, _name=${_name},_age=${_age})"

}