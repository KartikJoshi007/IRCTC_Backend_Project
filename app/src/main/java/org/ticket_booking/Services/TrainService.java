package org.ticket_booking.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ticket_booking.entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TrainService{

    private List<Train> trainList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String TRAIN_DB_PATH = "E:\\javaProjects\\IRCTC backend\\app\\src\\main\\java\\org\\ticket_booking\\localDB\\trains.json";

    public TrainService() throws IOException{
        File trains  = new File(TRAIN_DB_PATH);
        trainList = objectMapper.readValue(trains, new TypeReference<List<Train>>() {
        });
    }
    public void addTrain(Train newTrain){
        //CHeck if the train with same id already exist

    }






}
