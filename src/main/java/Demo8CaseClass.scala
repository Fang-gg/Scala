object Demo8CaseClass {
  def main(args: Array[String]): Unit = {
    val stu1: Stu = new Stu("001", "王五", 22, "男", "理科一班")
    println(stu1.id)
    println(stu1.name)
    println(stu1.age)
    println(stu1.gender)
    println(stu1.clazz)
    //如果样例类中的参数  就是该类的属性
    //默认是以val修饰 如果想要重新赋值  则需要手动指定为var
    stu1.age = 25
    println(stu1.age)
  }
}

/**
 * 样例类：会给每一个属性在编译的时候自动加上 ”get\set“方法，还会实现序列化接口
 */
case class Stu(id: String, name: String, var age: Int, gender: String, clazz: String) {

}