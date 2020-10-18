package com.wolox.socialnetwork.controllers.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.controllers.CommentController;
import com.wolox.socialnetwork.models.Comment;
import com.wolox.socialnetwork.services.SocialNetworkService;

@RestController
public class CommentControllerImpl implements CommentController {

	@Autowired
	private SocialNetworkService socialNetworkService;

	@Override
	public ResponseEntity<List<Comment>> doGetAllComments(Optional<String> name) {
		return new ResponseEntity<>(socialNetworkService.getAllComments(name), HttpStatus.OK);
	}

}
