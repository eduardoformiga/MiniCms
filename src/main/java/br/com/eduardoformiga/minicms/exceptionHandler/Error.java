package br.com.eduardoformiga.minicms.exceptionHandler;

public  class Error {

	private String userMessage;
	private String developerMessage;

	public Error(String userMessage, String developerMessage) {
		this.userMessage = userMessage;
		this.developerMessage = developerMessage;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}
}