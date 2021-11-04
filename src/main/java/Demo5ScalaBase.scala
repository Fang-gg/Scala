import com.mysql.jdbc.Driver

import java.io.{BufferedReader, FileReader}
import java.sql.{Connection, DriverManager, PreparedStatement, ResultSet}
import scala.io.{BufferedSource, Source}

object Demo5ScalaBase {
  /**
   * 基本语法
   */
  def main(args: Array[String]): Unit = {
    /**
     * 变量
     * 可以用val和var修饰，行医的时候不需要指定类型
     * 用val修饰的变量  不能进行修改
     * 用var修饰的变量  可以进行修改
     * 能用val就用val
     */
    val i = 100
    var j = 200

    println(i + 1) //不是修改
    //    i = 101  //这是修改 会直接报错

    /**
     * 类型推断
     */

    //自动推断
    val k = 100
    //手动加上类型
    val k1: Int = 100
    //多态:父类引用指向子类对象
    val k2: Object = "100"
    println(k)
    println(k1)
    println(k2.toString)

    /**
     * 类型转换
     * 只要数据符合要求就可以直接to+类型
     * 隐式转换 动态增加方法
     */
    //Java中的类型转换
    //Scala中的String就是Java中的String
    val str1 = "123"
    println(Integer.parseInt(str1))

    //Scala中的类型转换
    val i1: Int = str1.toInt
    println(i1)


    /**
     * String类型
     */

    val str: String = "Hello,World"
    println(str.split(","))


    /**
     * 字符串拼接
     */

    val str2: String = "abc" + "efg"
    println(str2)

    val builder: StringBuilder = new StringBuilder()
    builder.append("a")
    builder.append("bc")
    builder.append("ef")
    println(builder)

    val str3: String = "abc"
    val str4: String = "efg"
    val i3: Int = 10
    //Scala中的拼接方式
    //可以通过 $变量名 在字符串中取变量的值 底层也是StringBuilder
    println(s"$str3$str4$i3")

    println("=" * 50)

    /**
     * 文件读写
     */
    //Java的方式
    val reader: FileReader = new FileReader("Scala/data/students.txt")
    val br: BufferedReader = new BufferedReader(reader)
    var line = br.readLine()
    while (line != null) {
      println(line)
      line = br.readLine()
    }
    br.close()
    println("*" * 50)


    //Scala读文件
    val source: BufferedSource = Source.fromFile("Scala/data/students.txt")

    //返回一个迭代器
    //迭代器只能遍历一次
    val iter: Iterator[String] = source.getLines()

    //scala中的for each
    for (elem <- iter) {
      println(elem)
    }
    println("*"*50)
    //下面的不会遍历 因为scala中的迭代器只能遍历一次
    for (elem <- iter) {
      println(elem)
    }

    //第一种简化
    for (elem <- Source
      .fromFile("Scala/data/students.txt")
      .getLines()) {
      println(elem)
    }
    println("*" * 50)


    // 第二种简化
    // 链式调用
    Source
      .fromFile("Scala/data/students.txt")
      .getLines()
      .foreach(println)

    println("*" * 50)

    /**
     * 写文件PrintWriter、FileWriter
     * 都是Java中的类
     * Scala中没有特定的类
     */

    /**
     * JDBC
     */

    //1.加载驱动
    Class.forName("com.mysql.jdbc.Driver")
    //2.创建连接
    val connection: Connection = DriverManager.getConnection("jdbc:mysql://master:3306/student?useSSL=false", "root", "123456")
    //3.创建prepareStatement
    val statement: PreparedStatement = connection.prepareStatement("select * from student where age = ?")
    statement.setString(1,"22")
    val rs: ResultSet = statement.executeQuery()
    while (rs.next()){
      val name: String = rs.getString("name")
      val gender: String = rs.getString("gender")
      println(s"$name,$gender")
    }
    connection.close()

  }
}
