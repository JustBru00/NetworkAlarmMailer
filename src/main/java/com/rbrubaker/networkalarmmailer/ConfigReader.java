package com.rbrubaker.networkalarmmailer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.simpleyaml.configuration.file.YamlFile;

/**
* NetworkAlarmMailer - A program that monitors network variables and/or alarm statuses on supported controllers to provide alarm emails.
*   Copyright (C) 2024 Rufus Brubaker Refrigeration LLC
*
*   This program is free software: you can redistribute it and/or modify
*   it under the terms of the GNU General Public License as published by
*   the Free Software Foundation, either version 3 of the License, or
*   (at your option) any later version.
*
*   This program is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU General Public License for more details.
*
*   You should have received a copy of the GNU General Public License
*   along with this program.  If not, see <https://www.gnu.org/licenses/>
*   
*   You can contact us at rbr@rbrubaker.com.
* 
* @author Justin Brubaker
*
*/
public class ConfigReader {

	private static YamlFile config;
	
	private static String deviceName;
	private static String deviceLocation;
	
	private static String emailUsername;
	private static String emailPassword;
	private static String emailAddress;
	private static String emailServerHost;
	private static int emailPortNumber;
	private static String emailHighTempAlarmHtml;
	private static String emailLowTempAlarmHtml;
	
	private static ArrayList<String> globalReceiverAddresses = new ArrayList<String>();
	
	
	public static boolean loadConfig() {
		String path = "@NetworkAlarmMailer@config.yml";
		path = path.replace("@", File.separator);
		config = new YamlFile(path);
		
		try {
			if (config.exists()) {
				System.out.println("File already exists, loading configurations...\nFile located at: " + config.getFilePath() + "\n");
				config.load(); // Loads the entire file
			} else {
				System.out.println("Copying default config file: " + config.getFilePath() + "\n");
				copy(ConfigReader.class.getResourceAsStream("/default_files/config.yml"), path);
				config.load();
			}
		} catch(FileNotFoundException e) {		
			e.printStackTrace();
			System.out.println("Couldn't load the config file. FileNotFound");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
	
	/**
     * Copy a file from source to destination.
     *
     * @param source
     *        the source
     * @param destination
     *        the destination
     * @return True if succeeded , False if not
     */
    public static boolean copy(InputStream source , String destination) {
        boolean succeess = true;

        System.out.println("Copying ->" + source + "\n\tto ->" + destination);       		
        
        try {
        	 File file = new File(destination);
        	 if (file.exists()) {
        		 // Nothing
        	 } else {
        		 file.mkdirs();
        		 file.createNewFile();
        	 }
            Files.copy(source, Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
        	System.out.println("Failed to copy default config file.");
        	ex.printStackTrace();
          succeess = false;
        }

        return succeess;

    }
}
