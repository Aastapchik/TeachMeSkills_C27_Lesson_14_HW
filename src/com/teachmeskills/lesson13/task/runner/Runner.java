package com.teachmeskills.lesson13.task.runner;

import com.teachmeskills.lesson13.task.checker.Checker;
import com.teachmeskills.lesson13.task.consts.Consts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/*
The class simulates the operation of a program
 */
public class Runner {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\User\\IdeaProjects\\Proj13\\src\\com\\teachmeskills\\lesson13\\task\\files\\file";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine();
            while (line != null) {
                Checker.checkDoc(line, Consts.START_DOC, Consts.START_CONTRACT, Consts.filePathErr, Consts.filePathDoc, Consts.filePathContract);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Что-то пошло не так.");
        } catch (Exception e) {
            System.out.println("Вообще что-то пошло не так.");
        }


    }
}

