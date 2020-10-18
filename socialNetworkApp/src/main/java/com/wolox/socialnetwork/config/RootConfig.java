package com.wolox.socialnetwork.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = { "com.wolox.socialnetwork", "com.wolox.socialnetwork.config",
		"com.wolox.socialnetwork.controllers", "com.wolox.socialnetwork.controllers.impl",
		"com.wolox.socialnetwork.dto", "com.wolox.socialnetwork.exceptions",
		"com.wolox.socialnetwork.exceptions.handler", "com.wolox.socialnetwork.exceptions.models",
		"com.wolox.socialnetwork.models", "com.wolox.socialnetwork.repositories", "com.wolox.socialnetwork.security",
		"com.wolox.socialnetwork.services", "com.wolox.socialnetwork.services.impl",
		"com.wolox.socialnetwork.jsonplaceholder", "com.wolox.socialnetwork.jsonplaceholder.service",
		"com.wolox.socialnetwork.jsonplaceholder.service.impl" })
@Configuration
@PropertySource("file:${root.path}/app-directory/cfg/jsonPlaceHolderService/config.properties")
@PropertySource("file:${root.path}/app-directory/cfg/security/config.properties")
@PropertySource("file:${root.path}/app-directory/cfg/messages/config.properties")
public class RootConfig {

}
