package WeddingAgency;

import WeddingAgency.Models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> user) {
        return WeddingAgency.Models.User.class.isAssignableFrom(user);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "Поле  не может быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "required", "Поле не может быть пустым.");
    }
}