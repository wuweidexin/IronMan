package com.chen.dict;

import org.springframework.stereotype.Controller;

import net.sf.json.JSONObject;
@Controller
public class DictController {

	private String generateResult(){
		JSONObject reJson = JSONObject.fromObject("");

		JSONObject data = JSONObject.fromObject(reJson.get("data"));
		
		return null;
	}
}
