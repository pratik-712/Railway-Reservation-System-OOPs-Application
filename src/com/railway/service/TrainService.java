package com.railway.service;

import java.util.ArrayList;
import com.railway.model.Train;

public class TrainService {

    private ArrayList<Train> trains;

    public TrainService() {

        trains = new ArrayList<>();
    }

    public void addTrain(Train train) {

        trains.add(train);

        System.out.println(
                "Train added successfully.");
    }

    public void displayAllTrains() {

        if (trains.isEmpty()) {

            System.out.println("No trains available.");
            return;
        }

        System.out.println("\n========== ALL TRAINS ==========");

        for (Train train : trains) {

            train.displayTrainDetails();
        }
    }

    public Train findTrain(int trainNumber) {

        for (Train train : trains) {

            if (train.getTrainNumber() == trainNumber) {

                return train;
            }
        }

        return null;
    }

    public void searchTrain(String source, String destination) {

        boolean found = false;

        for (Train train : trains) {

            if (train.getSource().equalsIgnoreCase(source)
                    && train.getDestination().equalsIgnoreCase(destination)) {

                train.displayTrainDetails();
                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No train found for this route.");
        }
    }
}