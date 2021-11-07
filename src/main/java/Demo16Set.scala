import scala.collection.mutable

object Demo16Set {
  /**
   * Set 集合：无序、元素唯一、不可变、会自动去重
   */
  def main(args: Array[String]): Unit = {

    val set1: Set[Int] = Set(1, 1, 1, 1, 2, 2, 3, 4, 5, 5)
    println(set1)

    /**
     * 集合的运算： 交集 并集 差集
     */
    val set2: Set[Int] = Set(1, 2, 3, 4, 5)
    val set3: Set[Int] = Set(4, 5, 6, 7, 9)

    // 交集
    println(set2 & set3)
    // 并集
    println(set2 | set3)
    // 差集
    println(set2.diff(set3))

    // 可变的Set
    val hashSet: mutable.HashSet[Int] = mutable.HashSet(1, 2, 3, 3, 3, 4, 4, 5)
    println(hashSet)
    hashSet.+=(6)
    hashSet.+=(5)
    hashSet.+=(7)
    println(hashSet)

  }

}