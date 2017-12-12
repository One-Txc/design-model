package txc.xyz;

import java.util.Iterator;

public interface RequestInterceptorChain {
    Iterator<RequestInterceptor> getIterator();
    boolean addInterceptor(RequestInterceptor interceptor);
    void excue(Request req,Iterator<RequestInterceptor> iterator);
}
