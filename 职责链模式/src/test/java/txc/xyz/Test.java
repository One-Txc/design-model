package txc.xyz;


import org.junit.Before;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test {
    private List<RequestInterceptor> interceptorList;

    @Before
    public void before(){
        interceptorList = new LinkedList<RequestInterceptor>();
        interceptorList.add(new CheckInterceptor());
        interceptorList.add(new AgeInterceptor());
    }

    @org.junit.Test
    public void test(){
        Request req = new Request();
        Map<String,String> reqMap = req.getHeader();
        reqMap.put("name","txc");
        //reqMap.put("pwd","xyz");

        SimpleRequestInterceptorChain chain = new SimpleRequestInterceptorChain(interceptorList);

        Response resp = chain.excue(req);
        resp.getHeader();

    }
}
