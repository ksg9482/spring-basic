package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        //빈 생성시점에 requestURL를 알 수 없기 때문에 setter로 이후에 받음
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    //생성시점은 스프링 빈이 생성될 때. HTTP 요청 당 하나씩 생성됨.
    @PostConstruct
    public void init() {
        //요청당 하나씩이니 요청을 추적할 수 있음.
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope been create:" + this);

    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope been close:" + this);

    }
}
