package com.sparta.eng82.view;

import com.sparta.eng82.controller.SimulationImpl;
import com.sparta.eng82.model.*;

import java.util.HashMap;
import java.util.Map;

public class OutputManager {

    public void generateReport(SimulationImpl simulation, Integer month) {
        month--;
        System.out.println("\n##### Month: " + month + " #####");

        OutputManager outputManager = new OutputManager();
        // number of open centres
        System.out.println("-- Number of Open Centres per Type --");
        HashMap<String, Integer> temp = null;

        temp = outputManager.getNumberOfOpenCentres();

        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            System.out.println("Centre: " + entry.getKey() + " Count: " + entry.getValue().toString());
        }
        if (temp.isEmpty()) {
            System.out.println("...there are no open centres");
        }

        temp = outputManager.getNumberOfClosedCentres();
        // number of closed centres
        System.out.println("\n-- Number of Closed Centres per Type --");
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            System.out.println("Centre: " + entry.getKey() + " Count: " + entry.getValue().toString());
        }
        if (temp.isEmpty()) {
            System.out.println("...there are no closed centres");
        }

        temp = outputManager.getNumberOfFullCentres();
        // number of full centres
        System.out.println("\n-- Number of Full Centres per Type --");
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            System.out.println("Centre: " + entry.getKey() + " Count: " + entry.getValue().toString());
        }
        if (temp.isEmpty()) {
            System.out.println("...there are no full centres");
        }

        temp = outputManager.getNumberOfCurrentTrainees();
        // number of current trainees in training
        System.out.println("\n-- Number of Trainees in Training -- ");
        for (Map.Entry<String, Integer> entry : outputManager.getNumberOfCurrentTrainees().entrySet()) {
            System.out.println("Centre: " + entry.getKey() + " Count: " + entry.getValue().toString());
        }
        if (temp.isEmpty()) {
            System.out.println("...there are no current trainees in training");
        }

        temp = outputManager.getNumberOfTraineesWaiting(simulation);
        // number of current traines on waiting list
        System.out.println("\n-- Number of Trainees on the Waiting List --");
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            System.out.println("Course: " + entry.getKey() + " Count: " + entry.getValue().toString());
        }
        if (temp.isEmpty()) {
            System.out.println("...there are no trainees on the waiting list");
        }
    }

    //TODO make Private!
    public HashMap<String, Integer> getNumberOfOpenCentres() {

        Integer totalTech = 0;
        Integer totalBootcamp = 0;
        Integer totalTrainingHub = 0;

        HashMap<String, Integer> temp = new HashMap<>();

        for (TrainingCentre trainingCentre : SimulationImpl.trainingCentres) {
            if (trainingCentre.getClass().getSimpleName().equals("TechCentre") && !((TechCentre) trainingCentre).full()) {
                // if tech
                totalTech++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTech);
            }
            if (trainingCentre.getClass().getSimpleName().equals("Bootcamp") && !((Bootcamp) trainingCentre).full()) {
                // if bootcamp
                totalBootcamp++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalBootcamp);
            }
            if (trainingCentre.getClass().getSimpleName().equals("TrainingHub") && !((TrainingHub) trainingCentre).full()) {
                // if training hub
                totalTrainingHub++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTrainingHub);
            }
        }
        return temp;
    }

    private HashMap<String, Integer> getNumberOfClosedCentres() {
        Integer totalTech = 0;
        Integer totalBootcamp = 0;
        Integer totalTrainingHub = 0;

        HashMap<String, Integer> temp = new HashMap<>();

        for (TrainingCentre trainingCentre : SimulationImpl.trainingCentres) {
            if (trainingCentre.getClass().getSimpleName().equals("TechCentre") && !trainingCentre.getFunctionStatus()) {
                // if tech
                totalTech++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTech);
            }
            if (trainingCentre.getClass().getSimpleName().equals("Bootcamp") && !trainingCentre.getFunctionStatus()) {
                // if bootcamp
                totalBootcamp++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalBootcamp);
            }
            if (trainingCentre.getClass().getSimpleName().equals("TrainingHub") && !trainingCentre.getFunctionStatus()) {
                // if training hub
                totalTrainingHub++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTrainingHub);
            }
        }
        return temp;
    }


    private HashMap<String, Integer> getNumberOfFullCentres() {
        Integer totalTech = 0;
        Integer totalBootcamp = 0;
        Integer totalTrainingHub = 0;

        HashMap<String, Integer> temp = new HashMap<>();

        for (TrainingCentre trainingCentre : SimulationImpl.trainingCentres) {
            if (trainingCentre.getClass().getSimpleName().equals("TechCentre") && ((TechCentre) trainingCentre).full()) {
                // if tech
                totalTech++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTech);
            }

            if (trainingCentre.getClass().getSimpleName().equals("Bootcamp") && ((Bootcamp) trainingCentre).full()) {
                // if bootcamp
                totalBootcamp++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalBootcamp);
            }
            if (trainingCentre.getClass().getSimpleName().equals("TrainingHub") && ((TrainingHub) trainingCentre).full()) {
                // if training hub
                totalTrainingHub++;
                temp.put(trainingCentre.getClass().getSimpleName(), totalTrainingHub);
            }
        }
        return temp;
    }

    private HashMap<String, Integer> getNumberOfCurrentTrainees() {
        Integer totalTech = 0;
        Integer totalBootcamp = 0;
        Integer totalTrainingHub = 0;

        HashMap<String, Integer> temp = new HashMap<>();

        for (TrainingCentre trainingCentre : SimulationImpl.trainingCentres) {
            if (trainingCentre.getClass().getSimpleName().equals("TechCentre")) {
                // if tech
                totalTech += trainingCentre.getTraineeArraySize();
                temp.put(trainingCentre.getClass().getSimpleName(), totalTech);
            }
            if (trainingCentre.getClass().getSimpleName().equals("Bootcamp")) {
                // if bootcamp
                totalBootcamp += trainingCentre.getTraineeArraySize();
                temp.put(trainingCentre.getClass().getSimpleName(), totalBootcamp);
            }
            if (trainingCentre.getClass().getSimpleName().equals("TrainingHub")) {
                // if training hub
                totalTrainingHub += trainingCentre.getTraineeArraySize();
                temp.put(trainingCentre.getClass().getSimpleName(), totalTrainingHub);
            }
        }
        return temp;
    }

    private HashMap<String, Integer> getNumberOfTraineesWaiting(SimulationImpl simulation) {
        Integer totalJava = 0;
        Integer totalCsharp = 0;
        Integer totalData = 0;
        Integer totalDevops = 0;
        Integer totalBusiness = 0;

        HashMap<String, Integer> temp = new HashMap<>();
        for (Trainee trainee : simulation.getWaitingList()) {
            if(trainee!=null) {
                if (trainee.getCourseName().toString().equals("JAVA")) {
                    totalJava += 1;
                    temp.put("Java", totalJava);
                }
                if (trainee.getCourseName().toString().equals("C_SHARP")) {
                    totalCsharp += 1;
                    temp.put("C#", totalCsharp);
                }
                if (trainee.getCourseName().toString().equals("DATA")) {
                    totalData += 1;
                    temp.put("Data", totalData);
                }
                if (trainee.getCourseName().toString().equals("DEVOPS")) {
                    totalDevops += 1;
                    temp.put("DevOps", totalDevops);
                }
                if (trainee.getCourseName().toString().equals("BUSINESS")) {
                    totalBusiness += 1;
                    temp.put("Business", totalBusiness);
                }
            }
        }
        //  }
        return temp;
    }
}
