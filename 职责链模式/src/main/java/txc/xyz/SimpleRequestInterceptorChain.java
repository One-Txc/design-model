package txc.xyz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleRequestInterceptorChain implements RequestInterceptorChain{
    private List<RequestInterceptor> requestInterceptorList = new LinkedList<RequestInterceptor>();
    private Iterator<RequestInterceptor> iterator;
    //private Request req;


    public SimpleRequestInterceptorChain(List<RequestInterceptor> requestInterceptorList){
        this(requestInterceptorList,0);
    }

    public SimpleRequestInterceptorChain(List<RequestInterceptor> requestInterceptorList, int index){
        //this.req = req;
        this.requestInterceptorList = requestInterceptorList;
        if(requestInterceptorList == null || requestInterceptorList.size()<index){
            System.out.println("初始化异常－－应该抛出，暂不处理");
        }
        this.iterator = requestInterceptorList.iterator();
        if(index > 0){
            for (int i=0; i<index; i++){
                this.iterator.next();
            }
        }
    }
    public Response excue(Request req) {
        if(iterator.hasNext()){
            RequestInterceptor interceptor = iterator.next();
            return interceptor.deal(req,this);
        }
        //具体－－这里可以做Request的最终处理逻辑。或者这里不做处理，在拦截器最后添加最终处理的拦截器
        System.out.println("拦截器处理完成");
        HashMap<String, String> resMap = new HashMap<String, String>();
        resMap.put("status","200");
        resMap.put("msg","success");
        return new Response(resMap);
    }
}
