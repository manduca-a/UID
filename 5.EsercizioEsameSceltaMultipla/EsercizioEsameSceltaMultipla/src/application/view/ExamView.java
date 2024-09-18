package application.view;

import application.model.ExamTest;
import application.model.Question;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExamView extends JPanel {
    public ExamView(ExamTest examTest) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        List<Question> questions = examTest.getQuestions();
        for(Question q : questions) {
            JPanel smallPanel = new JPanel();
            smallPanel.setLayout(new BorderLayout());
            JLabel label = new JLabel(q.text());
            smallPanel.add(label, BorderLayout.PAGE_START);

            JPanel centerPanel = new JPanel();
            List<String> options = q.options();
            centerPanel.setLayout(new GridLayout(1, options.size()));
            for(String option : options) {
                JCheckBox checkBox = new JCheckBox(option);
                centerPanel.add(checkBox);
            }
            smallPanel.add(centerPanel);
            this.add(smallPanel);
        }
        JButton submit = new JButton("submit");
        this.add(submit);
    }
}
