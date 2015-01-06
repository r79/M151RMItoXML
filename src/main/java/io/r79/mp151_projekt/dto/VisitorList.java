package io.r79.mp151_projekt.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by rbuechle on 06.01.2015.
 */

@XmlRootElement(name="visitors")
public class VisitorList {
    private ArrayList<VisitorDTO> visitors;

    public VisitorList() {
        //empty stub
    }

    public VisitorList(ArrayList<VisitorDTO> visitors) {
        this.visitors = visitors;
    }

    @XmlElement(name="visitor")
    public ArrayList<VisitorDTO> getVisitors() {
        return visitors;
    }

    public void setVisitors(ArrayList<VisitorDTO> visitors) {
        this.visitors = visitors;
    }
}
