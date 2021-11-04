

public class Demo1Java {
    /**
     * Java中的main方法是由虚拟机调用的
     * 通过类对象去调用的
     * 类对象 --> 代码经过编译生成的.class字节码文件加载到内存的一个对象
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello World");


        /**
         * 在Java中使用Scala的类
         */
        new Demo4ScalaStu().print();
    }
}
