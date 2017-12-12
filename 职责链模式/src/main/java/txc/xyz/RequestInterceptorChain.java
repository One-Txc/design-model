package txc.xyz;

import java.util.Iterator;

public interface RequestInterceptorChain {
    Response excue(Request req);
}
