package DoesItHaveLegs;

//Node class
public class Animal {
    String data; //is a question or an animal
    Animal yes, no;
    boolean isQuestion;

    Animal(String data, boolean isQuestion) {
        this.data = data;
        this.isQuestion = isQuestion;
    }
}
