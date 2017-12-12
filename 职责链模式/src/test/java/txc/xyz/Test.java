package txc.xyz;


import org.junit.Before;

import java.util.Iterator;

public class Test {
    private RequestInterceptorChain requestInterceptorChain;

    @Before
    public void before(){
        requestInterceptorChain = new SimpleRequestInterceptorChain();
        requestInterceptorChain.addInterceptor(new CheckInterceptor());
        requestInterceptorChain.addInterceptor(new AgeInterceptor());
    }

    @org.junit.Test
    public void test(){
        Request req = new Request();
        //requestInterceptorChain.excue(req, requestInterceptorChain.getIterator());

//        Iterator<RequestInterceptor> i1 = requestInterceptorChain.getIterator();
//        System.out.println(i1.next().getClass()+"");
//        Iterator<RequestInterceptor> i2 = requestInterceptorChain.getIterator();
//        System.out.println(i2.next().getClass()+"");
//        System.out.println(i2.next().getClass()+"");

        System.out.println(requestInterceptorChain.getIterator() == requestInterceptorChain.getIterator());
    }
}
