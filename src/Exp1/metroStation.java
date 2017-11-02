package Exp1;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

/**
 * Created by dmitry on 5/16/17.
 */


@XmlRootElement
public class metroStation {
    String name;
    Integer yearOfOpening;
    static hour[] hours = new hour[24];
    public metroStation(String name, Integer yearOfOpening){
        this.name = name;
        this.yearOfOpening = yearOfOpening;
        array();
    }
    public metroStation() {
    }
    @XmlElement
    public String getName(){
        return name;
    }
    @XmlElement
    public hour[] getHours(){
        return hours;
    }
    @XmlElement
    public int getYearOfOpening(){
        return yearOfOpening;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setYearOfOpening(int yearOfOpening){
        this.yearOfOpening = yearOfOpening;
    }
    public  void setHours(hour[] hours) {
        metroStation.hours = hours;
    }
    @Override
    public String toString() {
        String forRet = name + '\n'  + yearOfOpening +'\n';
        for(hour temp:hours){
            forRet += temp.toString();
        }
        return forRet;
    }
    public void array(){
        for (int i = 0; i < 24 ; i++) {
            int temp = 2+(int)(Math.random()*10);
            String comment = "comment ", current = "comment ";
            for(int j = 0; j < temp; j++){
                current += comment;
            }
            if(i < 18)
                hours[i] = new hour(i,i*4562, current);
            else
                hours[i] = new hour(i,(i*30)+9856, current);
        }
    }
    public void sortByPasenger(){
        hour[] h = this.getHours();
        Arrays.sort(h, new CompareByNumOfPas());
        this.setHours(h);
    }
}
