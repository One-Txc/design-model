package txc.xyz;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleRequestInterceptorChain implements RequestInterceptorChain{
    private List<RequestInterceptor> requestInterceptorList = new LinkedList<RequestInterceptor>();
    ThreadLocal<Iterator> xx = new ThreadLocal<Iterator>();


    public boolean addInterceptor(RequestInterceptor interceptor){
        return requestInterceptorList.add(interceptor);
    }


    public void excue(Request req, Iterator<RequestInterceptor> iterator) {
        if(iterator.hasNext()){
            RequestInterceptor interceptor = iterator.next();
            interceptor.deal(req,this,iterator);
        }else {
            //具体
            System.out.println("拦截器处理完成");
        }
    }

    public Iterator<RequestInterceptor> getIterator() {
        return requestInterceptorList.iterator();
    }
}
