package hello.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

//@Quilifier에 있는 애노테이션 복사한다.
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
//@Quilifier도 붙여서 지정해줌
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
