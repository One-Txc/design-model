package txc.xyz.test;

import txc.xyz.Moveable;
import txc.xyz.Tank;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * jdk自带编译器功能测试
 * Created by txc on 17-12-20.
 */
public class Test1 {
    public static void main(String[] args) throws Exception{
        String src = "package txc.xyz;\n" +
                "\n" +
                "public class TankTimeProxy implements Moveable{\n" +
                "    private Moveable m;\n" +
                "    public TankTimeProxy(Moveable m){\n" +
                "        this.m = m;\n" +
                "    }\n" +
                "    @Override\n" +
                "    public void move() {\n" +
                "        long start = System.currentTimeMillis();\n" +
                "        m.move();\n" +
                "        long end = System.currentTimeMillis();\n" +
                "        System.out.println(\"time:\" + (end - start));\n" +
                "    }\n" +
                "}";
        String fileName = System.getProperty("user.dir")+"/代理模式/src/main/java/txc/xyz/TankTimeProxy.java";
        System.out.println(fileName);

        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();

        //compile
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(compiler.getClass().getName());
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null,null,null);
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask t = compiler.getTask(null,fileMgr,null,null,null,units);
        boolean result = t.call();
        System.out.println(result);
        fileMgr.close();

        //load into memory and create an instance
        URL[] urls = new URL[]{new URL("file:/"+System.getProperty("user.dir")+"/代理模式/src/main/java")};
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("txc.xyz.TankTimeProxy");
        System.out.println(c);

        Constructor ctr = c.getConstructor(Moveable.class);
        Moveable m = (Moveable) ctr.newInstance(new Tank());
        m.move();


    }
}
