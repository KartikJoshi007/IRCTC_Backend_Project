package org.ticket_booking.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ticket_booking.entities.User;

import java.io.File;
import java.util.List;

public class UserBooking
{
    private User user;
    private List<User> userList;
    private static final String USER_PATH = "../localDB/users.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    public UserBooking(User user1){
        this.user = user1;
        File users = new File(USER_PATH);
        

    }




}
