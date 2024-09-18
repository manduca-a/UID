package application.model;

import java.util.List;

public record Question(String text, List<String> options){
}
