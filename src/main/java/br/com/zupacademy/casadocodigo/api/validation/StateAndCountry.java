package br.com.zupacademy.casadocodigo.api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StateAndCountryValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface StateAndCountry {
    String message() default "{validation.existsState.default}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
