package com.wolox.socialnetwork.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.controller.CommentController;
import com.wolox.socialnetwork.model.Comment;
import com.wolox.socialnetwork.service.SocialNetworkService;

@RestController
public class CommentControllerImpl implements CommentController {

	@Autowired
	private SocialNetworkService socialNetworkService;
	
	@Override
	public ResponseEntity<List<Comment>> doGetAllComments(String name) {
		return new ResponseEntity<>(socialNetworkService.getAllComments(name), HttpStatus.OK);
	}

}
