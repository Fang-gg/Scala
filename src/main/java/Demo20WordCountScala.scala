import scala.io.{BufferedSource, Source}

object Demo20WordCountScala {
  def main(args: Array[String]): Unit = {
    //1、读取文件
    val bs: BufferedSource = Source.fromFile("Scala/data/words.txt")

    //2、将每一行数据转成List中的每一个元素
    val list: List[String] = bs.getLines().toList

    //3.将每一行数据中的单词切分出来
    val words: List[String] = list.flatMap(line => {
      line.split(",")
    })

    // 4、按照每个单词分组
    /**
     * groupBy 指定分组的列
     * 最终会返回 k-v 格式的数据
     * k ： 指定的分组的列
     * v ： 符合分组条件的所有的元素共同组成的一个List
     * 实际上groupBy默认会返回一个Map
     */
    val groupby: Map[String, List[String]] = words.groupBy(word => word)

    // 5、统计每个单词的数量
    val wordCnt: Map[String, Int] = groupby.map{
      case (id: String, values: List[String]) =>
        val tuple: (String, Int) = {
          val key: String = id
          val value: List[String] = values
          (key, value.size)
        }
        //      val key: String = kv._1
        //      val values: List[String] = kv._2
        //      val cnt: Int = values.size
        //      (key, cnt)
        tuple
    }

    // 6、打印
    wordCnt.foreach(println)


    // 链式调用
    Source
      .fromFile("Scala/data/words.txt")
      .getLines()
      .toList
      .flatMap(_.split(","))
      .groupBy(word => word)
      .map(kv => (kv._1, kv._2.size))
      .foreach(println)


    //关闭
    bs.close()
  }
}
