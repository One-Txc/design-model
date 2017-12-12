package txc.xyz;


import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.Map;

public class CheckInterceptor implements RequestInterceptor{
    public void deal(Request req, RequestInterceptorChain chain, Iterator<RequestInterceptor> iterator) {
        System.out.println("CheckInterceptor.deal");
        Map<String,String> map = req.getHeader();
        String name = map.get("name");
        String pwd = map.get("pwd");
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(pwd)){
            System.out.println("验证失败");
        }else {
            System.out.println("验证通过");
        }
        chain.excue(req,iterator);
    }
}
