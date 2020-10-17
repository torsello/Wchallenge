package com.wolox.socialnetwork.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.model.Comment;

@RestController
@RequestMapping("/api/comments")
public interface CommentController {
	
	@GetMapping
	public ResponseEntity<List<Comment>> doGetAllComments(@RequestParam Optional<String> name);
	
}
