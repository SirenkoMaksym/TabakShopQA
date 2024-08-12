/*
 * created by max$
 */


package com.tabakshop.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

//    @DataProvider(name = "registrationPositiveData")
//    public Iterator<Object[]> registrationNewUserFromCsv() throws IOException {
//        List<Object[]> list = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new FileReader
//                (new File("src/test/resources/positiveRegistration.csv")));
//        String line = reader.readLine();
//
//        while (line != null) {
//            list.add(line.split(","));
//            line = reader.readLine();
//        }
//        return list.iterator();
//    }

    @DataProvider(name = "positiveEmail")
    public Iterator<Object[]> registrationNewUser1FromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/positiveEmail.csv")));
        String line = reader.readLine();

        while (line != null) {
            list.add(new Object[]{line.trim()});
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
    @DataProvider(name = "registrationNegativeEmail")
    public Iterator<Object[]> registrationNewUserWithWrongEmailFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/wrongEmail.csv")));
        String line = reader.readLine();

        while (line != null) {
            list.add(new Object[]{line.trim()});
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
    @DataProvider(name = "registrationNegativePassword")
    public Iterator<Object[]> registrationNewUserWithWrongPasswordFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/wrongPassword.csv")));
        String line = reader.readLine();

        while (line != null) {
            list.add(new Object[]{line.trim()});
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

    @DataProvider(name = "example")
    public Iterator<Object[]> registrationExampleUser1FromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/exampleEmail.csv")));
        String line = reader.readLine();

        while (line != null) {
            list.add(new Object[]{line.trim()});
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

}
