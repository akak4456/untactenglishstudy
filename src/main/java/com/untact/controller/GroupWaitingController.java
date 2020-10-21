package com.untact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.untact.service.groupinclude.GroupIncludeService;
import com.untact.vo.GroupWaitingVO;

import lombok.extern.java.Log;

@RestController
@Log
public class GroupWaitingController {
	@Autowired
	private GroupIncludeService groupIncludeService;
	
	@PostMapping("/waiting")
	public ResponseEntity<String> requestJoin(@RequestBody GroupWaitingVO groupWaitingVO	){
		groupIncludeService.requestJoin(groupWaitingVO);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	
	@PutMapping("/waiting/{gino}/accept")
	public ResponseEntity<String> acceptJoin(@PathVariable("gino")Long gino){
		groupIncludeService.acceptJoin(gino);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	
	@PutMapping("/waiting/{gino}/reject")
	public ResponseEntity<String> rejectJoin(@PathVariable("gino")Long gino){
		groupIncludeService.rejectJoin(gino);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
}
