package com.truckdispature.controllers;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.truckdispature.dao.Register;
import com.truckdispature.dto.Driver;
import com.truckdispature.dto.DriverEntity;
import com.truckdispature.dto.LoadMaster;
import com.truckdispature.dto.Owner;
import com.truckdispature.dto.Transaction_details;
import com.truckdispature.dto.Truck;
import com.truckdispature.dto.TruckEntity;
import com.truckdispature.view.ExcelTransListReportView;
import com.truckdispature.view.PdfTransListReportView;

@Controller
public class Controllers {

	private static final Logger logger = Logger.getLogger(Controllers.class);

	@Autowired
	Register reg;

	@RequestMapping("/home")
	public String homePage() {

		return "login";

	}

	@RequestMapping("/login")
	public ModelAndView login() {

		List<String> list1 = reg.getAllExpirydetails();

		int count = list1.size();
		ModelAndView map = new ModelAndView("home");
		map.addObject("list", list1);
		map.addObject("count", count);
		return map;

	}

	@RequestMapping("/owner")
	public String ownerProfile(Model model) {
		model.addAttribute("newowner", new Owner());
		return "owner";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String ownerRegister(RedirectAttributes redirectAttributes, @ModelAttribute("newowner") Owner rdto) {

		reg.saveOwner(rdto);
		redirectAttributes.addFlashAttribute("msg", "<b><h2>Owner  details successfully added</h2></b>");
		return "redirect:/viewowner";
	}

	@RequestMapping("/truck")
	public ModelAndView truckProfile(Model model) {

		List<Owner> list = reg.getOwner();
		ModelAndView map = new ModelAndView("truck");
		map.addObject("list", list);
		model.addAttribute("newtruck", new Truck());
		return map;
	}

	@RequestMapping(value = "/truckregistration", method = RequestMethod.POST)
	public String truckRegister(@ModelAttribute Truck rdto, RedirectAttributes redirectAttributes) {
		reg.saveTruck(rdto);
		redirectAttributes.addFlashAttribute("msg", "<b><h2>Truck details successfully added</h2></b>");
		return "redirect:/viewtruck";
	}

	@RequestMapping(value = "/viewtruck", method = RequestMethod.GET)
	public ModelAndView getAllTruck() {

		List<TruckEntity> listoftruck = reg.getAllTrucks();
		ModelAndView map = new ModelAndView("viewalltruck");
		map.addObject("list", listoftruck);
		return map;
	}

	@RequestMapping(value = "/viewowner", method = RequestMethod.GET)
	public ModelAndView viewAllTruck() {

		List<Owner> list = reg.getOwner();
		ModelAndView map = new ModelAndView("viewallowner");
		map.addObject("list", list);
		return map;
	}

	@RequestMapping(value = "/deletetruck", method = RequestMethod.GET)
	public String deleteTruck(@RequestParam String trucknumber, RedirectAttributes redirectAttributes) {

		reg.deleteTruck(trucknumber);
		redirectAttributes.addFlashAttribute("msg", "<b><h2>Truck details successfully deleted</h2></b>");
		return "redirect:/viewtruck";
	}

	@RequestMapping(value = "/deleteowner", method = RequestMethod.GET)
	public String deleteowner(@RequestParam String ssn, RedirectAttributes redirectAttributes) {

		reg.deleteowner(ssn);
		redirectAttributes.addFlashAttribute("msg", "<b><h2>Owner details successfully deleted</h2></b>");
		return "redirect:/viewowner";
	}

	@RequestMapping("/editowner")
	public ModelAndView editOwner(@RequestParam String ssn, Model model) {

		Owner owner = reg.editowner(ssn);
		model.addAttribute("ownerEdit", owner);
		ModelAndView map = new ModelAndView("Editowner");
		map.addObject("ownerobj", owner);

		return map;

	}

	@RequestMapping("/updateOwner")
	public String updateowner(@ModelAttribute("ownerEdit") Owner rdto, RedirectAttributes redirectAttributes) {

		reg.updateOwner(rdto);
		redirectAttributes.addFlashAttribute("msg", "<b><h2>Owner details successfully updated</h2></b>");

		return "redirect:/viewowner";

	}

	@RequestMapping("/edittruck")
	public ModelAndView edittruck(@RequestParam String trucknumber, Model model) {

		Truck truck = reg.edittruck(trucknumber);
		model.addAttribute("truckEdit", truck);
		List<Owner> list = reg.getOwner();
		ModelAndView map = new ModelAndView("Edittruck");
		map.addObject("truckobj", truck);
		map.addObject("list", list);

		return map;

	}

	@RequestMapping("/updateTruck")
	public String updatetruck(@ModelAttribute("truckEdit") Truck rdto, RedirectAttributes redirectAttributes) {

		reg.updateTruck(rdto);
		redirectAttributes.addFlashAttribute("msg", "<b><h2>Truck details successfully updated</h2></b>");
		return "redirect:/viewtruck";

	}

	@RequestMapping("/driver")
	public ModelAndView driverProfilen(Model model) {

		List<Owner> list = reg.getOwner();
		List<TruckEntity> list1 = reg.getAllTrucks();

		ModelAndView map = new ModelAndView("driver");
		map.addObject("list", list);
		map.addObject("list1", list1);
		model.addAttribute("newdriver", new Driver());
		return map;
	}

	@RequestMapping(value = "/driverregister", method = RequestMethod.POST)
	public String driverRegister(@ModelAttribute Driver rdto, RedirectAttributes redirectAttributes) {
		reg.saveDriver(rdto);
		redirectAttributes.addFlashAttribute("msg", "<b><h2>Driver details successfully added</h2></b>");
		return "redirect:/viewdriver";
	}

	@RequestMapping(value = "/viewdriver", method = RequestMethod.GET)
	public ModelAndView getAllDriver() {

		List<DriverEntity> listofdriver = reg.getAllDriver();
		ModelAndView map = new ModelAndView("viewalldriver");
		map.addObject("list", listofdriver);
		return map;
	}

	@RequestMapping(value = "/deletedriver", method = RequestMethod.GET)
	public String deleteDriver(@RequestParam String ssn, RedirectAttributes redirectAttributes) {

		reg.deleteDriver(ssn);
		redirectAttributes.addFlashAttribute("msg", "<b><h2>Driver details successfully deleted</h2></b>");
		return "redirect:/viewdriver";
	}

	@RequestMapping("/editdriver")
	public ModelAndView editDriver(@RequestParam String ssn, Model model) {

		Driver driver = reg.editdriver(ssn);

		model.addAttribute("driverEdit", driver);
		List<Owner> list = reg.getOwner();

		List<TruckEntity> list1 = reg.getAllTrucks();

		ModelAndView map = new ModelAndView("Editdriver");
		map.addObject("driverobj", driver);
		map.addObject("list", list);
		map.addObject("list1", list1);

		return map;

	}

	@RequestMapping("/updateDriver")
	public String updatedriver(@ModelAttribute("driverEdit") Driver rdto, RedirectAttributes redirectAttributes) {

		reg.updateDriver(rdto);
		redirectAttributes.addFlashAttribute("msg", "<b><h2>Driver details successfully updated</h2></b>");
		return "redirect:/viewdriver";

	}

	@RequestMapping("/logout")
	public String logout(RedirectAttributes redirectAttributes) {

		redirectAttributes.addFlashAttribute("msg", "<b><h2>Logout successfully </h2></b>");
		return "redirect:/home";

	}

	@RequestMapping("/load")
	public ModelAndView scheduleLoad(Model model) {
		model.addAttribute("newload", new LoadMaster());

		List<TruckEntity> list = reg.getAllTrucks();

		ModelAndView map = new ModelAndView("load");
		map.addObject("list", list);
		return map;
	}

	@RequestMapping(value = "/addload", method = RequestMethod.POST)
	public String loadschedule(@ModelAttribute("newload") LoadMaster rdto, RedirectAttributes redirectAttributes) {

		reg.addload(rdto);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		Transaction_details ldt = new Transaction_details();

		ldt.setAdvancetype("ADVANCE");
		ldt.setAdvance(rdto.getTotalamountpaid());
		ldt.setLoadnumber(rdto.getLoadNumber());
		ldt.setGrossaftercommission(rdto.getGrossafterCommision());
		ldt.setDatetime(timestamp);

		reg.addinstallment(ldt);

		redirectAttributes.addFlashAttribute("msg", "<b><h2>Load details successfully added</h2></b>");

		return "redirect:/viewload";
	}

	@RequestMapping(value = "/viewload", method = RequestMethod.GET)
	public ModelAndView getAllLoad() {

		List<LoadMaster> listofload = reg.getAllLoad();
		List<LoadMaster> listofload1 = reg.getAllLoadclose();
		ModelAndView map = new ModelAndView("viewallload");
		map.addObject("list", listofload);
		map.addObject("list2", listofload1);
		return map;
	}

	@RequestMapping("/editload")
	public ModelAndView editLoad(@RequestParam Integer loadnumber, Model model, RedirectAttributes redirectAttributes) {

		LoadMaster loadmaster = reg.editLoad(loadnumber);
		model.addAttribute("loadedit", loadmaster);
		List<TruckEntity> list = reg.getAllTrucks();
		ModelAndView map = new ModelAndView("Editload");
		map.addObject("loadobj", loadmaster);
		map.addObject("list", list);
		return map;

	}

	@RequestMapping("/updateload")
	public String updatetruck(@ModelAttribute("loadedit") LoadMaster rdto, RedirectAttributes redirectAttributes) {

		reg.updateLoad(rdto);
		redirectAttributes.addFlashAttribute("msg", "<b><h2>Load details successfully updated</h2></b>");
		return "redirect:/viewload";

	}

	@RequestMapping("/addEmi")
	public ModelAndView addEmi(@RequestParam Integer lid, Model model) {

		model.addAttribute("newinstallment", new Transaction_details());
		LoadMaster load = reg.getLoadnumber(lid);
		Double getlastamount = reg.getlastadvance(lid);
		ModelAndView map = new ModelAndView("addEmi");
		map.addObject("remaingross", getlastamount);
		map.addObject("load", load);
		return map;
	}

	@RequestMapping("/addinstallment")
	public String addInstallment(@ModelAttribute("newinstallment") Transaction_details rdto,
			RedirectAttributes redirectAttributes) {

		Double getlastamount = reg.getlastadvance(rdto.getLoadnumber());
		rdto.setGrossaftercommission(getlastamount - rdto.getAdvance());
		reg.addinstallment(rdto);
		reg.addTotalAdvance(rdto);
		redirectAttributes.addFlashAttribute("msg", "<b><h2>Advance payment details successfully added</h2></b>");
		return "redirect:/viewload";
	}

	@RequestMapping("/viewtransaction")
	public ModelAndView viewTrasactions(@RequestParam Integer lid) {

		List<Transaction_details> list = reg.getTrasactionDetails(lid);
		ModelAndView map = new ModelAndView("trasactionsheet");
		map.addObject("lid", lid);
		map.addObject("list", list);
		return map;
	}

	@RequestMapping("/closeload")
	public String closeLoad(@RequestParam Integer lid, RedirectAttributes redirectAttributes) {

		reg.closeLoad(lid);
		redirectAttributes.addFlashAttribute("msg", "<b><h2>Load details successfully closed</h2></b>");
		return "redirect:/viewload";
	}

	@RequestMapping(value = "/report", method=RequestMethod.GET)
	public ModelAndView transListReport(HttpServletRequest request, HttpServletResponse response)

	{

		String typeReport = request.getParameter("type");
		String lid = request.getParameter("loadnumber");
		
			String truckNumber1=request.getParameter("truckNumber");
		
			String ownerName=reg.getownerDetails(truckNumber1);
			
			request.setAttribute("owner",ownerName);
			
			Integer transNo= reg.getLastTransId(Integer.parseInt(lid));
			request.setAttribute("transId",transNo);
		
		
		List<Transaction_details> list = reg.getTrasactionDetails(Integer.parseInt(lid));
		

		if (typeReport != null && typeReport.equals("xls")) {

			return new ModelAndView(new ExcelTransListReportView(), "transList", list);
		}

		else if (typeReport != null && typeReport.equals("pdf")) {

			return new ModelAndView(new PdfTransListReportView(), "transList", list);
		}

		return new ModelAndView("trasactionsheet", "transList", list);

	}
	
	@RequestMapping("/editEmi")
	public ModelAndView editEmi(@RequestParam Integer transId, Model model) {

		Transaction_details transaction_details= reg.getTransaction(transId);
		Transaction_details transaction_details2= reg.getTransactionbefor(transaction_details.getLoadnumber());
		
		LoadMaster load = reg.getLoadnumber(transaction_details.getLoadnumber());
		Double getlastamount = reg.getlastadvance(transaction_details.getLoadnumber());

		System.out.println(transaction_details.getTransno());
		
		transaction_details.setGrossaftercommission(transaction_details2.getGrossaftercommission());
		load.setTotalamountpaid(load.getTotalamountpaid()-transaction_details.getAdvance());
		
		model.addAttribute("emiEdit", transaction_details);
		ModelAndView map = new ModelAndView("editEmi");
		map.addObject("emiobj", transaction_details);
		map.addObject("remaingross", getlastamount);
		map.addObject("load", load);
		
		return map;

	}
	

	@RequestMapping("/updateEmi")
	public String updatetruck(@ModelAttribute("emiEdit") Transaction_details rdto, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		
		rdto.setTransno(Integer.parseInt(request.getParameter("transno")));
		reg.updateEmi(rdto);
		redirectAttributes.addFlashAttribute("msg", "<b><h2>Transaction details successfully updated</h2></b>");
		return "redirect:/viewload";

	}

}
