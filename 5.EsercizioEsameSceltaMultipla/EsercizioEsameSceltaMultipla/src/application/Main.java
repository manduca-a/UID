package application;

import application.model.ExamTest;
import application.model.QuestionReader;
import application.view.ExamFrame;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        ExamFrame f = new ExamFrame();
        try {
            File file = f.selectFile();
            QuestionReader reader = new QuestionReader();
            ExamTest test = reader.readExam(file);
            f.showExam(test);
        } catch (Exception e) {
            f.showErrorMessageAndTerminate();
        }
    }
}
