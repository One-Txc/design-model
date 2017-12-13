package txc.xyz;


public interface RequestInterceptor {
    Response deal(Request req,RequestInterceptorChain chain);
}
