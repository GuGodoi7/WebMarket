package br.com.fiap.webmarket.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoCategoriaValidator implements ConstraintValidator<TipoCategoria, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       return value.equals("ELETRONICO") || value.equals("VESTIMENTA");
    }

}
