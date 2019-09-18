package com.truckdispature.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.truckdispature.dao.Register;
import com.truckdispature.dto.Transaction_details;

@Repository
public class PdfTransListReportView extends AbstractPdfView {


	@Autowired
	Register reg;
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		response.setHeader("Content-Disposition", "attachment; filename=\"trans_list.pdf\"");
		
		String truckNumber1=request.getParameter("truckNumber");
		String ownerName= (String)request.getAttribute("owner");
		
		document.add(new Paragraph("Trasaction Details of Owner "+ownerName+" and Truck Number "+truckNumber1));
		
		@SuppressWarnings("unchecked")
		List<Transaction_details> list= (List<Transaction_details>) model.get("transList");
		
		Table table = new Table(6);
		
		
		table.addCell("Trasaction Id");
		table.addCell("DateTime");
		table.addCell("Advance");
		table.addCell("GrossAfterCommission");
		table.addCell("Advance Type");
		table.addCell("Load Number");
		
		for(Transaction_details trans:list)
		{
			
			table.addCell(String.valueOf(trans.getTransno()));
			table.addCell(String.valueOf(trans.getDatetime()));
			table.addCell(String.valueOf(trans.getAdvance()));
			table.addCell(String.valueOf(trans.getGrossaftercommission()));
			table.addCell(String.valueOf(trans.getAdvancetype()));
			table.addCell(String.valueOf(trans.getLoadnumber()));
		}
		
		document.add(table);
		
	}

}
