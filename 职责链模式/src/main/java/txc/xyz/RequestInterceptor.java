package txc.xyz;

import java.util.Iterator;

public interface RequestInterceptor {
    Response deal(Request req,RequestInterceptorChain chain);
}
