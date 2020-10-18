package com.wolox.socialnetwork.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.socialnetwork.models.Comment;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/comments")
@Api(tags = "Comments")
public interface CommentController {

	@GetMapping
	@ApiOperation(value = "List all Comments or filtered by name", notes = "This service returns a list of comments")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Comments found"),
			@ApiResponse(code = 404, message = "Commetns not found") })
	public ResponseEntity<List<Comment>> doGetAllComments(@RequestParam Optional<String> name);

}
