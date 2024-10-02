package gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(-1) //定義執行順序，數字越小最優先
@Component //讓過濾器生效，將其注入到spring當中作為一個bean
public class AuthorizeFilter implements GlobalFilter {
    /**
     *
     * @param exchange 請求上下文，裡面可以獲得request、response等資料
     * @param chain 可以把請求委託給下一個filter
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.取得request
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> params = request.getQueryParams();
        //2.取得params中的authorization資料
        String auth = params.getFirst("authorization");
        //3.判斷參數是否為admin
        if("admin".equals(auth)){
            //4. 符合並放行
            return chain.filter(exchange);
        }
        //5.不符合，攔截並設置狀態碼
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }
}
