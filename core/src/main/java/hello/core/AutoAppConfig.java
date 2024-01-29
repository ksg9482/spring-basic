package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration //설정정보 선언
@ComponentScan(
        //자동으로 컴포넌트 긁어오는데 그중에서 뺄 거 지정
        excludeFilters = @ComponentScan.Filter(
                // Configuration 애노테이션 붙은건 뺀다. 다른 Configuration 읽는 거 방지
                // 다른 예제에서도 Configuration쓴다. 실무에선 보통 이런일 없음.
                type = FilterType.ANNOTATION,
                classes = Configuration.class
        )
) //자동으로 컴포넌트를 스캔
public class AutoAppConfig {
}
