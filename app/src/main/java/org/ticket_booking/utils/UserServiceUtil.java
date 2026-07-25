package org.ticket_booking.utils;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceUtil {

    public static String hashPassword(String plainPassword){
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plainpassword, String hashpassword) {
    return BCrypt.checkpw(plainpassword, hashpassword);
    }
}
