package br.com.zupacademy.casadocodigo.api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BrazilianDocumentValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BrazilianDocument {
    String message() default "{validation.braziliandocument.default}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
