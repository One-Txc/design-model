package txc.xyz;

import java.util.HashMap;
import java.util.Map;

public class Response {
    private Map<String,String> header = new HashMap<String, String>();

    public Response(Map<String,String> map){
        this.header = map;
    }

    public Map<String, String> getHeader() {
        return header;
    }
    public void setHeader(Map<String, String> header) {
        this.header = header;
    }
}
