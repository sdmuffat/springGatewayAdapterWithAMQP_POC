/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.integration.samples.amqp;

import org.apache.log4j.Logger;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Starts the Spring Context and will initialize the Spring Integration message flow.
 *
 * @author Gunnar Hillert
 * @version 1.0
 *
 */
public final class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	private Main() { }

	/**
	 * Load the Spring Integration Application Context
	 *
	 * @param args - command line arguments
	 */
	public static void main(final String... args) {

		LOGGER.info("\n========================================================="
				  + "\n                                                         "
				  + "\n          Welcome to Spring Integration!                 "
				  + "\n                                                         "
				  + "\n    For more information please visit:                   "
				  + "\n    http://www.springsource.org/spring-integration       "
				  + "\n                                                         "
				  + "\n=========================================================" );

		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/integration/*-context.xml");

		context.registerShutdownHook();

		LOGGER.info("\n========================================================="
				  + "\n                                                          "
				  + "\n    This is the AMQP Sample -                             "
				  + "\n                                                          "
				  + "\n    Please enter some text and press return. The entered  "
				  + "\n    Message will be sent to the configured RabbitMQ Queue,"
				  + "\n    then again immediately retrieved from the Message     "
				  + "\n    Broker and ultimately printed to the command line.    "
				  + "\n                                                         "
				  + "\n    values to use:                                           "
				  + "\n           good   // creates a valid message that is processed quickly                                     "
				  + "\n           null   // returns a null value.  this is potentially a valid use case, but see timeout case                                    "
				  + "\n           bad    // throws an exception and it doesnt propagate.                                       "
				  + "\n           slow   // puts in a sleep of 10 seconds.  the gateway should respond with a null                                     "
				  + "\n           print  // reprints this message                                               "
				  + "\n                                                          "
				  + "\n=========================================================" );

	}
}
