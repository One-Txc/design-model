package txc.xyz;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class AgeInterceptor implements RequestInterceptor{
    public Response deal(Request req, RequestInterceptorChain chain) {
        System.out.println("AgeInterceptor.deal");
        Map<String,String> map = req.getHeader();
        String age = map.get("age");
        if(StringUtils.isEmpty(age)){
            System.out.println("没有age，添加age");
            map.put("age","22");
        }else {
            System.out.println("有age，不处理");
        }
        return chain.excue(req);
    }
}
