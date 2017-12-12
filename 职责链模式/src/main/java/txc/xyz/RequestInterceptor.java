package txc.xyz;

import java.util.Iterator;

public interface RequestInterceptor {
    void deal(Request req,RequestInterceptorChain chain,Iterator<RequestInterceptor> iterator);
}
