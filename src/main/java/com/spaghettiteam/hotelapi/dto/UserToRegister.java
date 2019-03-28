package com.spaghettiteam.hotelapi.dto;

public class UserToRegister {

    private String username;
    private String password;
    private String passwordConfirmation;
    private String email;

    public UserToRegister(String username, String password, String passwordConfirmation, String email) {
        this.username = username;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public String getEmail() {
        return email;
    }

    public static final class Builder {
        private String username;
        private String password;
        private String passwordConfirmation;
        private String email;

        private Builder() {
        }

        public static Builder anUserToRegister() {
            return new Builder();
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder passwordConfirmation(String passwordConfirmation) {
            this.passwordConfirmation = passwordConfirmation;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public UserToRegister build() {
            return new UserToRegister(username, password, passwordConfirmation, email);
        }
    }
}
