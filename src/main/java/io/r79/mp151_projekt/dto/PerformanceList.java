package io.r79.mp151_projekt.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by rbuechle on 06.01.2015.
 */

@XmlRootElement(name="performancelist")
public class PerformanceList {
    private ArrayList<PerformanceDTO> performances;

    public PerformanceList() {
        //empty stub
    }

    public PerformanceList(ArrayList<PerformanceDTO> performances) {
        this.performances = performances;
    }

    @XmlElement(name="performance")
    public ArrayList<PerformanceDTO> getPerformances() {
        return performances;
    }

    public void setPerformances(ArrayList<PerformanceDTO> performances) {
        this.performances = performances;
    }
}
