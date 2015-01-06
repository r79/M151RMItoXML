package com.springapp.mvc;

import io.r79.mp151_projekt.dto.PerformanceDTO;
import io.r79.mp151_projekt.dto.PerformanceList;
import io.r79.mp151_projekt.dto.VisitorDTO;
import io.r79.mp151_projekt.dto.VisitorList;
import io.r79.mp151_projekt.rmiInterface.FilmClubInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sun.misc.Perf;

import javax.xml.ws.RespectBinding;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping
@ResponseStatus(HttpStatus.OK)
public class MainController {

	@RequestMapping(value="/performances/{start}/{end}", produces={"application/xml"})
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public PerformanceList getPerformances(@PathVariable long start, @PathVariable long end) throws RemoteException, NotBoundException, MalformedURLException {
		Date startDate = new Date(start);
		Date endDate = new Date(end);

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		System.out.println("incoming Request | Performances | start= " + sdf.format(start) + " | end= " + sdf.format(end) + " |");

		FilmClubInterface filmClubInterface = (FilmClubInterface) Naming.lookup("//localhost/SQLService");

		ArrayList<PerformanceDTO> performances = filmClubInterface.getPerformances(startDate, endDate);


		System.out.println("responded " + performances.size() + " Performances");

		return new PerformanceList(performances);
	}

	@RequestMapping(value="/visitors/{performanceId}", produces={"application/xml"})
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public VisitorList getVisitors(@PathVariable int performanceId) throws RemoteException, NotBoundException, MalformedURLException {

		System.out.println("incoming Request | Visitors | performanceId= " + performanceId + " |");

		FilmClubInterface filmClubInterface = (FilmClubInterface) Naming.lookup("//localhost/SQLService");

		ArrayList<VisitorDTO> visitors = filmClubInterface.getVisitors(performanceId);

		System.out.println("responded " + visitors.size() + " Visitors");

		return new VisitorList(visitors);
	}
}
