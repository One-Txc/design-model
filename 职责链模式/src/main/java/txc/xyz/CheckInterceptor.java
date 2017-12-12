package txc.xyz;


import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CheckInterceptor implements RequestInterceptor{
    public Response deal(Request req, RequestInterceptorChain chain) {
        System.out.println("CheckInterceptor.deal");
        Map<String,String> map = req.getHeader();
        String name = map.get("name");
        String pwd = map.get("pwd");
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(pwd)){
            System.out.println("验证失败");
            HashMap<String, String> resMap = new HashMap<String, String>();
            resMap.put("status","400");
            resMap.put("msg","400");
            return new Response(resMap);
        }
        System.out.println("验证通过");
        return chain.excue(req);
    }
}
