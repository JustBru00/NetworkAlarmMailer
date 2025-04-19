package com.rbrubaker.networkalarmmailer;

import java.time.Duration;
import java.time.Instant;

public class NetworkAlarmMailer {
	
	public static boolean running = true;
	public static final String VERSION = "Version 1.0.0-SNAPSHOT";
	private static Instant lastUpdate;	

	public static void main(String[] args) {
		System.out.println("NetworkAlarmMailer " + VERSION);
		System.out.println("NetworkAlarmMailer - A program that monitors network variables and/or alarm statuses on supported controllers to provide alarm emails.\r\n"
				+ "*   Copyright (C) 2025 Rufus Brubaker Refrigeration LLC\r\n"
				+ "*\r\n"
				+ "*   This program is free software: you can redistribute it and/or modify\r\n"
				+ "*   it under the terms of the GNU General Public License as published by\r\n"
				+ "*   the Free Software Foundation, either version 3 of the License, or\r\n"
				+ "*   (at your option) any later version.\r\n"
				+ "*\r\n"
				+ "*   This program is distributed in the hope that it will be useful,\r\n"
				+ "*   but WITHOUT ANY WARRANTY; without even the implied warranty of\r\n"
				+ "*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\r\n"
				+ "*   GNU General Public License for more details.\r\n"
				+ "*\r\n"
				+ "*   You should have received a copy of the GNU General Public License\r\n"
				+ "*   along with this program.  If not, see <https://www.gnu.org/licenses/>\r\n"
				+ "*   \r\n"
				+ "*   You can contact us at rbr@rbrubaker.com.");
		System.out.println("* https://github.com/JustBru00/NetworkAlarmMailer");
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
	        public void run() {
	            try {	            	
	                Thread.sleep(200);	                
	                System.out.println("\nReceived shutdown request from system. (CTRL-C)");
	                
	                running = false;	                
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    });
		
		if (!ConfigReader.loadConfig()) {
			return;
		}

		// Wait a while -> Poll network controllers -> Check values against alarm config -> Send email alarms
		if (lastUpdate == null) {
			lastUpdate = Instant.now();
		}

		// Every 5 minutes
		if (Duration.between(lastUpdate, Instant.now()).getSeconds() >= 300) {

		}

	}

}
