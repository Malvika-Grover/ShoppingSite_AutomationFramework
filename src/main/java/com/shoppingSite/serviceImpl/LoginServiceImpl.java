package com.shoppingSite.serviceImpl;


import com.shoppingSite.model.User;
import com.shoppingSite.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.nio.charset.Charset;
import java.util.List;

import static org.apache.tomcat.util.codec.binary.Base64.decodeBase64;

@Slf4j
@Service
public class LoginServiceImpl implements com.shoppingSite.service.LoginService {

    @Autowired
    UserRepository userRepository;


    @Override
    public Boolean isValidUser(String username, String password) {
        if (null == username && null == password) {
            log.info("username or password is null");
            return false;
        }
        User user = userRepository.findByUsernameIn(username);
        if (null == user) {
            log.info("not a valid user");
            return false;
        }
        if (null == user.getPassword()) {
            log.info("passord is null");
            return false;
        }
        if (password.equals(user.getPassword())) {
            return true;
        }

        return false;
    }

    @Override
    public String getUsernameFromAuthToken(byte[] token) {
        String auth = Base64.decodeBase64(token).toString();
        int i =0;
        String username = "";
        while (auth.charAt(i) != ":") {
            username = username + auth.charAt(i);
            i++;

        }
        return username;

    }

}
