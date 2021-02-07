package com.epam.talixo.framework.data;

import com.epam.talixo.framework.data.entities.User;
import com.epam.talixo.framework.utils.JsonUtils;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class RegistrationDataStorage {

    private static final String REGISTRATION_DATA_DIR = "/testData/registrationData/";

    /**
     * This method return User data from JSON file.
     *
     * @param fileName the name of the file from which the data is to be returned
     * @return an User objects
     */
    public static User[] getUsers(String fileName) {
        return JsonUtils.readJsonArray(REGISTRATION_DATA_DIR + fileName, User[].class);
    }

    public static User getUserByFirstName(String fileName, String userName) {
        return findUser(getUsers(fileName), e -> e.getFirstName().equals(userName));
    }

    public static User findUser(User[] users, Predicate<User> userPredicate) {
        return Stream.of(users).filter(userPredicate).findFirst().orElse(null);
    }

}