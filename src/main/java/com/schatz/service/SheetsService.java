package com.schatz.service;

import java.io.IOException;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.sheets.v4.Sheets;

public interface SheetsService {	
	public Credential authorize() throws IOException, Exception;
	public Sheets getSheetsService() throws IOException, Exception;	
}
