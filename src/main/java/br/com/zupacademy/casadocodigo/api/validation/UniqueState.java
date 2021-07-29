package br.com.zupacademy.casadocodigo.api.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UniqueStateValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueState {
    String message() default "{validation.uniquestate.default}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
