package txc.xyz;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleRequestInterceptorChain implements RequestInterceptorChain{
    private List<RequestInterceptor> requestInterceptorList = new LinkedList<RequestInterceptor>();
    private Iterator<RequestInterceptor> iterator;
    private Request req;

    public SimpleRequestInterceptorChain(Request req, List<RequestInterceptor> requestInterceptorList, int index){
        this.req = req;
        this.requestInterceptorList = requestInterceptorList;
        if(requestInterceptorList == null || requestInterceptorList.size()<index){
            System.out.println("初始化异常－－应该抛出，暂不处理");
        }
        this.iterator = requestInterceptorList.listIterator(index);
    }

    public void excue(Request req) {

        //


        if(iterator.hasNext()){
            RequestInterceptor interceptor = iterator.next();
            interceptor.deal(req,this);
        }else {
            //具体
            System.out.println("拦截器处理完成");
        }




    }

    public void setRequestInterceptorList(List<RequestInterceptor> requestInterceptorList) {
        this.requestInterceptorList = requestInterceptorList;
    }
}
