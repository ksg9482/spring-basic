package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        //생성되기 직전에 출력
        //이거 출력된 후
        System.out.println("find prototypeBean1");
        //이게 생성되었음
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        //초기화 각각 다른 시점에 두 번 수행됨
        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        //close 호출 안됨
        ac.close();

        //직접 처리해야 함
        prototypeBean1.destroy();
        prototypeBean2.destroy();
    }

    //@Component 안 붙여도 동작하는 이유
    //AnnotationConfigApplicationContext에 지정하면 컴포넌트 스캔되서 들어간다.
    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct()
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy()
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
