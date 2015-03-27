package com.project.betelguese.server.connection.utils;

import java.util.HashMap;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import javax.swing.SwingWorker;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.project.betelguese.server.connection.utils.Response.ErrorListener;
import com.project.betelguese.server.connection.utils.Response.Listener;

public class ServerRequest<S> extends Service<S> implements
		EventHandler<WorkerStateEvent> {

	private S s;
	private Listener<S> listener;
	private ErrorListener errorListener;
	private String url;
	private HashMap<String, String> params;
	private int method;
	private static final int UNDONE = 0;
	private static final int DONE = 1;
	private int doneCheck;

	public ServerRequest(final int method, String url,
			HashMap<String, String> params, Listener<S> listener,
			ErrorListener errorListener) {
		setOnSucceeded(this);
		setOnFailed(this);
		this.method = method;
		this.url = url;
		this.params = params;
		this.listener = listener;
		this.errorListener = errorListener;
		doneCheck = 0;
	}

	protected S doInBackground() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("doInBackground()" + " " + method);
		try {
			switch (method) {
			case Response.GET:
				s = (S) getMethod();
				doneCheck = 1;
				break;
			case Response.POST:
				System.out.println("POST Response Method");
				s = (S) postMethod();
				doneCheck = 1;
				break;
			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			doneCheck = 0;
			s = (S) e;
		}
		return null;
	}

	private String getMethod() throws Exception {
		System.out.println("getMethod()");
		HttpUtility.sendGetRequest(url);
		String response = HttpUtility.readSingleLineRespone();
		return response;
	}

	@SuppressWarnings("unchecked")
	private String postMethod() throws Exception {
		System.out.println("postMethod()");
		StringBuffer sumUp = new StringBuffer();
		System.out.println(params.toString());
		HttpUtility.sendPostRequest(url, params);
		String[] response = HttpUtility.readMultipleLinesRespone();
		for (String line : response) {
			System.out.println("Aass done in try");
			if (line != null) {
				sumUp.append(line);
			}
		}
		s = (S) sumUp.toString();
		HttpUtility.disconnect();
		System.out.println(sumUp.toString());
		return sumUp.toString();
	}

	@Override
	protected Task<S> createTask() {
		// TODO Auto-generated method stub
		return new Task<S>() {

			@Override
			protected S call() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("call()");
				return doInBackground();
			}
		};
	}

	@Override
	public void handle(WorkerStateEvent arg0) {
		// TODO Auto-generated method stub
		switch (doneCheck) {
		case DONE:
			try {
				listener.onResponse(s);
			} catch (Exception e) {
				if (e.getMessage()
						.equals("java.lang.String cannot be cast to org.json.simple.JSONObject")) {
					JSONParser jsonParser = new JSONParser();
					try {
						s = (S) jsonParser.parse((String) s);
						listener.onResponse(s);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					errorListener.onErrorResponse((Exception) e);
				}
			}
			break;
		case UNDONE:
			errorListener.onErrorResponse((Exception) s);
			break;
		default:
			break;
		}
		doneCheck = 0;
	}

}
