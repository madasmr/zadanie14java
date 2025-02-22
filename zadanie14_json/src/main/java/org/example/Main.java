package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws JSONException {
        String jsonData = """
        {
            "company": "Tech Solutions",
            "employees": [
                {
                    "id": 1,
                    "name": "Alice Smith",
                    "age": 30,
                    "position": "Software Engineer",
                    "skills": ["Java", "Spring", "SQL"]
                },
                {
                    "id": 2,
                    "name": "Bob Johnson",
                    "age": 25,
                    "position": "Data Analyst",
                    "skills": ["Python", "Pandas", "Excel"]
                },
                {
                    "id": 3,
                    "name": "Charlie Brown",
                    "age": 35,
                    "position": "Project Manager",
                    "skills": ["Agile", "Scrum", "Leadership"]
                },
                {
                    "id": 4,
                    "name": "David Miller",
                    "age": 28,
                    "position": "Backend Developer",
                    "skills": ["Java", "Kotlin", "Microservices"]
                }
            ],
            "location": {
                "address": "456 Technology Dr",
                "city": "Innovate City",
                "state": "CA",
                "zip": "90210"
            },
            "established": 2010
        }
        """;

        JSONObject companyData = new JSONObject(jsonData);

        //Сотрудники старше 25 лет
        System.out.println("Сотрудники старше 25 лет:");
        JSONArray employees = companyData.getJSONArray("employees");
        for (int i = 0; i < employees.length(); i++) {
            JSONObject employee = employees.getJSONObject(i);
            if (employee.getInt("age") > 25) {
                System.out.println(employee.toString());
            }
        }

        System.out.println();

        //Сотрудник с id = 3
        System.out.println("Сотрудник с id = 3:");
        for (int i = 0; i < employees.length(); i++) {
            JSONObject employee = employees.getJSONObject(i);
            if (employee.getInt("id") == 3) {
                System.out.println(employee.toString());
                break;
            }
        }

        System.out.println();

        //Сотрудники с навыком Java
        System.out.println("Сотрудники с навыком Java:");
        for (int i = 0; i < employees.length(); i++) {
            JSONObject employee = employees.getJSONObject(i);
            JSONArray skills = employee.getJSONArray("skills");
            for (int j = 0; j < skills.length(); j++) {
                if (skills.getString(j).equals("Java")) {
                    System.out.println(employee.toString());
                    break;
                }
            }
        }
    }
}