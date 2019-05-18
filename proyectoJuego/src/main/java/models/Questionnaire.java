package models;
import controllers.Questions;
public class Questionnaire extends Player
{
    
    Questions qs = new Questions();
    
    public Questionnaire(int score)
    {
        super(score);
    }
    public void apliQuestionnaire(int score)
    {
        int counter;
        counter = score;
        if (counter<=2){
            qs.easy();
        }//if
    }//apliQuestionnaire
    
}//Questionnaire
