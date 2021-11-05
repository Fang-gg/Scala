object Demo10Apply {
  def main(args: Array[String]): Unit = {
    val a: A1 = new A1("001", "张三")
    val b: B1 = new B1("001", "张三")
    val lisi: B1 = B1.apply("002", "李四")
    val wangwu: B1 = B1("003", "王五")

    B1.fun()
    //    B1.apply("oo")
    //    B1("hhh") // 会默认调用Objcet B1 中的 apply方法

  }

}

class A1(id: String, name: String) {
  val _id: String = id
  val _name: String = name
}

class B1(id: String, name: String) {
  val _id: String = id
  val _name: String = name
}

// 称为B1的伴生对象
object B1 {
  def fun(): Unit = {
    println("fun")
  }

  // 会返回一个对象，该对象的类型是跟Object同名的一个类
  def apply(id: String, name: String): B1 = {
    val b1 = new B1(id, name)
    return b1
  }
}