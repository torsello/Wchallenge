package com.wolox.socialnetwork.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = { "com.wolox.socialnetwork", "com.wolox.socialnetwork.config", "com.wolox.socialnetwork.controller", "com.wolox.socialnetwork.controller.impl",
		"com.wolox.socialnetwork.exceptions", "com.wolox.socialnetwork.exceptions.handler",
		"com.wolox.socialnetwork.exceptions.models", "com.wolox.socialnetwork.model", "com.wolox.socialnetwork.repositories",
		"com.wolox.socialnetwork.security", "com.wolox.socialnetwork.service", "com.wolox.socialnetwork.service.impl", "com.wolox.socialnetwork.firebase","com.wolox.socialnetwork.utils"})
@Configuration
@PropertySource("file:${root.path}/app-directory/cfg/jsonPlaceHolderService/config.properties")
public class RootConfig {

}
