package main.java.by.punko.repository.specification;

import java.util.Arrays;
import java.util.List;

public class PersonInsert implements Parameter{
    private String login;
    private String email;
    private String phone;
    public PersonInsert(String login, String email, String phone) {
        this.login = login;
        this.email = email;
        this.phone = phone;
    }
    @Override
    public List<Object> getParameters() {
        return Arrays.asList(login, email, phone);
    }
}
