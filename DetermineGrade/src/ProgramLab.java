/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 03/02/26
	Assignment: Module 4 Lab(LM)
	Instructor: Sergio Pisano
	Description: Determines overall Grade in class based on criteria
 */
import java.util.*;

public class ProgramLab {
//driver 
	public static void main(String[] args) {
		displayGrades(calculateGrades(inputGrades())); //<--read me in reverse <--
	}

//get formatted input for grades from user
	public static Map<String, ?> inputGrades() {
		Scanner scnr = new Scanner(System.in);
		
		String studentStatus = "undefined";
		
		Double homeworkPoints = 0.0;
		Double quizPoints = 0.0;
		Double midtermScore = 0.0;
		Double finalScore = 0.0;
		
		Map<String, ?> scoreMap;
		
		//get status
		//System.out.println("Enter your registration status");
		try {
			studentStatus = scnr.next();
		} catch (InputMismatchException e) {
			System.err.print(e.getMessage());
		}
		
		//get homework
		//System.out.println("Enter points for homework - Double");
		try {
			homeworkPoints = scnr.nextDouble();
		} catch (InputMismatchException e) {
			System.err.print("Error: please enter as ###.#");
		}
		
		
		//get quizzes
		//System.out.println("Enter points for quizzes - Double");
		try {
			quizPoints = scnr.nextDouble();
		} catch (InputMismatchException e) {
			System.err.print("Error: please enter as ###.#");
		}
		
		//get mid-term
		//System.out.println("Enter Score for midterm - Double");
		try {
			midtermScore = scnr.nextDouble();
		} catch (InputMismatchException e) {
			System.err.print("Error: please enter as ###.#");
		}
		
		
		//get final
		//System.out.println("Enter Score for final - Double");
		try { 
			finalScore = scnr.nextDouble();
		} catch (InputMismatchException e) {
			System.err.print("Error: please enter as ###.#");
		}
		
		//pack status and grades in a map for 
		//data transfer between functions
		scoreMap = Map.of(
				"status", studentStatus,
				"homework", homeworkPoints, 
				"quiz", quizPoints,
				"midterm", midtermScore, 
				"final", finalScore
				);
		scnr.close();
		return scoreMap;
	}
	
//calculations on variables, status/grade averages
	public static Map<String, ?> calculateGrades(Map<String, ?> grades) {
		Map<String, Object> calculatedGrades;
		
		boolean verifiedStatus = false;
		String studentStatus = "undetermined";
		Double calculatedHW;
		Double calculatedQuiz;
		Double calculatedMidterm;
		Double calculatedFinal;
		Double calculatedOverall;
		String courseGrade = "F";
		
		//calculate status validity
		String[] validInputs = {"UG", "G", "DL"};
		
		String statusCheck = grades.get("status").toString();
		for (int i = 0; i < validInputs.length; i++) {
			if ((validInputs[i].toLowerCase().equals(statusCheck.toLowerCase()) == true) && (verifiedStatus == false)) {
				verifiedStatus = true;
				studentStatus = statusCheck;
			}
		}
			
		//calculate homework average
		Double gradeChange = (Double)grades.get("homework");
		calculatedHW = gradeChange / 8.0;
		if (calculatedHW > 100) {
			calculatedHW = 100.0;
		}
		
		//calculate quizzes average
		gradeChange = (Double)grades.get("quiz");
		calculatedQuiz = gradeChange / 4.0;
		if (calculatedQuiz > 100.0) {
			calculatedQuiz = 100.0;
		}
		
		//calculate midterm Score average
		gradeChange = (Double)grades.get("midterm");
		calculatedMidterm = gradeChange / 1.5;
		if (calculatedMidterm > 100.0) {
			calculatedMidterm = 100.0;
		}
		
		//calculate final Score average
		gradeChange = (Double)grades.get("final");
		calculatedFinal = gradeChange / 2.0;
		if (calculatedFinal > 100.0) {
			calculatedFinal = 100.0;
		}
		
		//calculate overall
		switch (studentStatus.toLowerCase()) {
			case "ug":
				calculatedOverall = (calculatedHW * 0.2) + (calculatedQuiz * 0.2) 
				+ (calculatedMidterm * 0.3) + (calculatedFinal * 0.3);
				break;
			case "g":
				calculatedOverall = (calculatedHW * 0.15) + (calculatedQuiz * 0.05) + (calculatedMidterm * 0.35) + (calculatedFinal * 0.45);
				break;
			case "dl":
				calculatedOverall = (calculatedHW * 0.05) + (calculatedQuiz * 0.05) + (calculatedMidterm * 0.4) + (calculatedFinal * 0.5);
				break;
			default:
				calculatedOverall = (calculatedHW * 0.25) + (calculatedQuiz * 0.25) + (calculatedMidterm * 0.25) + (calculatedFinal * 0.25);
				break;
			
		}
		
		if (calculatedOverall >= 90) {
			courseGrade = "A";
		} else if (calculatedOverall >= 80) {
			courseGrade = "B";
		} else if (calculatedOverall >= 70) {
			courseGrade = "C";
		} else if (calculatedOverall >= 60) {
			courseGrade = "D";
		}
		
		calculatedGrades = Map.of(
					"verifiedStatus", verifiedStatus,
					"studentStatus", studentStatus,
					"calculatedHW", calculatedHW,
					"calculatedQuiz", calculatedQuiz,
					"calculatedMidterm", calculatedMidterm,
					"calculatedFinal", calculatedFinal,
					"calculatedOverall", calculatedOverall,
					"courseGrade", courseGrade
				);
		
		return calculatedGrades;
	}
	
	//output for step 1
	public static void displayGrades(Map<String, ?> grades) {
		if ((boolean)grades.get("verifiedStatus") == true) {
			System.out.printf("Homework: %.1f%%\n", grades.get("calculatedHW"));
			System.out.printf("Quizzes: %.1f%%\n", grades.get("calculatedQuiz"));
			System.out.printf("Midterm: %.1f%%\n", grades.get("calculatedMidterm"));
			System.out.printf("Final Exam: %.1f%%\n", grades.get("calculatedFinal"));
			System.out.print(grades.get("studentStatus").toString() + " ");
			System.out.printf("average: %.1f%%\n", grades.get("calculatedOverall"));
			System.out.println("Course grade: " + grades.get("courseGrade").toString());
		} else {
			System.out.println("Error: student status must be UG, G or DL");
		}
	}
}
/*
fhdpq
600.0
300.0
120.0
185.0
Error: student status must be UG, G or DL
*/