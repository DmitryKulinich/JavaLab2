package Exp1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Created by dmitry on 5/16/17.
 */
@XmlRootElement
public class hour {
    private int oclock;
    private int numberOfPassenger;
    private static int sumOfPassenger;
    private String comment;
    public hour(int oclock,int numberOfPassenger, String comment){
        this.comment = comment;
        this.numberOfPassenger = numberOfPassenger;
        sumOfPassenger+=numberOfPassenger;
        if (oclock < 0 || oclock > 23){
            System.out.println("wrong oclock!!!");
        } else {
            this.oclock = oclock;
        }
    }
    public hour() {
    }
    public static void setSumOfPassenger(int sumOfPassenger)
    {
        hour.sumOfPassenger = sumOfPassenger;
    }
    @XmlElement
    public void setOclock(int oclock){

            this.oclock = oclock;

    }
    @XmlElement
    public void setNumberOfPassenger(int numberOfPassenger){
        this.numberOfPassenger = numberOfPassenger;
        sumOfPassenger+=numberOfPassenger;
    }
    @XmlElement
    public void setComment(String comment){
        this.comment = comment;
    }
    public int getSumOfPassenger(){
        return sumOfPassenger;
    }
    public int getOclock(){
        return oclock;
    }
    public int getNumberOfPassenger(){
        return numberOfPassenger;
    }
    public String getComment(){
        return comment;
    }
    @Override
    public String toString(){
       return getOclock()+"\n"+getComment() +"\n"+getNumberOfPassenger() + "\n";
    }
    public int countOfWordsInComment(){
        int countOfWords = 0;
        for(char element: comment.toCharArray()){
            if(element == ' '){
                countOfWords++;
            }
        }
        return countOfWords;
    }
}
