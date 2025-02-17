package com.java.jquery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.jquery.message.Response;
import com.java.jquery.model.CustermorDtd;

@RestController
public class DataTableController {

	@Autowired
	HttpSession session;

	@PostMapping(value = "/postData")
	public @ResponseBody Boolean ShowData(@RequestBody CustermorDtd cust) {
		session.setAttribute("custmerData", cust);
		return Boolean.TRUE;

	}

	@GetMapping(value = "/dataTableFromSession")
	public Response dataTableFromSession() {
		CustermorDtd cust = (CustermorDtd) session.getAttribute("custmerData");
		Response response = new Response("Done", cust);
		return response;
	}
}
