import scala.collection.mutable

object Demo18Map {
  /**
   * Map 相当于Python中的dict
   * 里面每一个元素都是 k-v格式的
   * 无序的，key是不能重复的
   * 不可变的
   */
  def main(args: Array[String]): Unit = {
    val map: Map[String, String] = Map(("k1", "v1"), ("k2", "v2"), "k3" -> "v3")
    println(map)

    // 判断某个key存不存在
    println(map.contains("k1"))
    println(map.contains("k4"))

    // 根据key获取value
    println(map("k1"))
    println(map.get("k2")) // Some(v2)
    println(map.get("k2").get) // v2
    println(map.get("k4")) // None
    println(map.getOrElse("k3", "不存在"))
    println(map.getOrElse("k4", "不存在"))

    val map2: Map[String, String] = map.filter((tuple2) => {
      var flag = false
      val key: String = tuple2._1
      val value: String = tuple2._2
      if (key == "k2") {
        flag = true
      }
      flag
    })

    println(map2)
    println(map.filter(_._1 == "k2"))


    /**
     * 可变的Map
     */
    val hashMap: mutable.HashMap[String, String] = mutable.HashMap("k1" -> "v1", "k2" -> "v2", "k3" -> "v3")
    hashMap.+=("k4" -> "v4")
    println(hashMap)
  }

}