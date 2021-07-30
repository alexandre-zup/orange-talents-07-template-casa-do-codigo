package br.com.zupacademy.casadocodigo.api.validation;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.*;

@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR)
@ReportAsSingleViolation
@Documented
@Constraint(validatedBy = { })
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BrazilianDocument {
    String message() default "{validation.braziliandocument.default}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
