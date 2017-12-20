package txc.xyz;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by txc on 17-12-20.
 */
public class Proxy {

    public static Object newProxyInstance(Class infce,Object o) throws Exception{

        String mSrc = "";
        for (Method m:infce.getMethods()){
            mSrc = mSrc + getMethodSrc(m);
        }
        String src = "package txc.xyz;\n" +
                "\n" +
                "public class TankTimeProxy implements "+infce.getName()+"{\n" +
                "    private "+infce.getName()+" m;\n" +
                "    public TankTimeProxy("+infce.getName()+" m){\n" +
                "        this.m = m;\n" +
                "    }\n" +
                mSrc+
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

        Constructor ctr = c.getConstructor(infce);
        return ctr.newInstance(o);

    }

    private static String getMethodSrc(Method m){
        String returnType = m.getReturnType().getName();
        String name = m.getName();
        Class[] paramTypeList = m.getParameterTypes();
        String paramList1 = "";
        String paramList2 = "";
        int i = 0;
        for (Class paramClass:paramTypeList){
            if(!"".equals(paramList1)){
                paramList1 = paramList1+",";
            }
            if(!"".equals(paramList2)){
                paramList2 = paramList2+",";
            }
            paramList1 = paramList1 + paramClass.getName() +" param"+i;
            paramList2 = paramList2 + "param"+i;
            i++;
        }
        String mSrc = "    @Override\n" +
                      "    public {returnType} {name}({paramList1}) {\n" +
                      "        long start = System.currentTimeMillis();\n" +
                      "        m.{name}({paramList2});\n" +
                      "        long end = System.currentTimeMillis();\n" +
                      "        System.out.println(\"time:\" + (end - start));\n" +
                      "        return 0;\n"+
                      "    }\n";
        mSrc = mSrc.replace("{returnType}",returnType)
                .replace("{name}",name)
                .replace("{paramList1}",paramList1)
                .replace("{paramList2}",paramList2);
        return mSrc;
    }
}
