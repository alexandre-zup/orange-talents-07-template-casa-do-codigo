package br.com.zupacademy.casadocodigo.api.validation;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BrazilianDocumentValidator implements ConstraintValidator<BrazilianDocument, String> {
    private CPFValidator cpfValidator = new CPFValidator();
    private CNPJValidator cnpjValidator = new CNPJValidator();

    @Override
    public void initialize(BrazilianDocument constraintAnnotation) {
        cpfValidator.initialize(null);
        cnpjValidator.initialize(null);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean cpfValido = cpfValidator.isValid(value, context);
        boolean cnpjValido = cnpjValidator.isValid(value, context);

        return  cpfValido || cnpjValido;
    }
}
