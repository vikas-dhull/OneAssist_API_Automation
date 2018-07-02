package com.OneAssist.com.OneAssist_API_Automation.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.jsonschema2pojo.AnnotationStyle;
import org.jsonschema2pojo.Annotator;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.GsonAnnotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.sun.codemodel.JCodeModel;

import com.google.gson.Gson;



public class APIMethods {
				
		public Response Get(String url, HashMap<String, String> headers)
				throws Exception {
			Response response = new Response();
			
			//SetHttpsCertificationByPass();
			
			long startTime = System.currentTimeMillis();
			HttpURLConnection connection = clientURLConnection(url, headers, "GET");
			
			long responseTime = System.currentTimeMillis() - startTime;
			int responseCode = GetResponseCode(connection);
			response.setResponseHeaders(getResponseHeaders(connection));
			String respns = "";
			
			
			
			
			if (new Integer(responseCode).toString().startsWith("2")) {
				InputStream inputStream = connection.getInputStream();
				respns = readInputStream(inputStream).toString();
				response.setResponse(respns);
			}else {
				//Gson gson = new Gson();
				InputStream inputStream = connection.getErrorStream();
				List<String> list = getReponseHeaderInfo(connection,"Content-Encoding");
				respns = readInputStream(inputStream).toString();
				//ErrorResponse eResp = getErrorResponseHandler(respns);
				//response.setErrorResponse(eResp); 
				////Need to handle error resposne
			}
			
			response.setResponse(respns);
			response.setResponseTime(responseTime);
			response.setStatusCode(responseCode);
			return response;
		}
		
		
		
		
		public Response Post(String url, HashMap<String, String> headers,
				String json) throws URISyntaxException, MalformedURLException,
		IOException {
			//System.out.println("Json is"+json);
			Response response = new Response();
			//if (url.contains("login") || url.contains("test")) {
			//SetHttpsCertificationByPass();
			//}
			HttpURLConnection connection = clientURLConnection(url, headers, "POST");
			long startTime = System.currentTimeMillis();
			long responseTime;
			OutputStream outputStream = connection.getOutputStream();
			
			//OutputStreamWriter outputStream = new OutputStreamWriter(connection.getOutputStream());
			
			if (!json.equals("")) {
				byte sendData[] = json.getBytes("utf-8");
				
				outputStream.write(sendData);
				responseTime = System.currentTimeMillis() - startTime;
				outputStream.flush();
				outputStream.close();
			} else {
				responseTime = 0;
			}
			int responseCode = GetResponseCode(connection);
			//System.out.println("responseCode: "+responseCode);
			response.setStatusCode(responseCode);
			response.setResponseHeaders(getResponseHeaders(connection));

			String respns;
			if(new Integer(responseCode).toString().startsWith("2"))
			{
				InputStream inputStream = connection.getInputStream();
				respns = readInputStream(inputStream).toString();
			}
			else {
				Gson gson = new Gson();
				InputStream inputStream = connection.getErrorStream();
				List<String> list = getReponseHeaderInfo(connection,"Content-Encoding");
					respns = readInputStream(inputStream).toString();
				//System.out.println(respns);
				//ErrorResponse eResp = getErrorResponseHandler(respns);
				//response.setErrorResponse(eResp);
			}
			response.setResponse(respns);
			response.setResponseTime(responseTime);
			return response;
		}
		
		
		public HttpURLConnection clientURLConnection(String url,
				HashMap<String, String> headers, String Action)
						throws MalformedURLException, IOException, URISyntaxException {

			URL uri = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
			//connection.setConnectTimeout(5000);//set timeout to 5 sec

			if(headers!=null){
				Set set = headers.entrySet();
				Iterator it = set.iterator();
				while (it.hasNext()) {
					Map.Entry me = (Map.Entry) it.next();

					connection.addRequestProperty(me.getKey().toString(), me.getValue()
							.toString());
				}
			}
			
			connection.setDoInput(true);
			connection.setDoOutput(true); // This sets request method to
			connection.setRequestMethod(Action); 
			//connection.setConnectTimeout(15);
			//connection.setReadTimeout(15000);
			
			// Action(POSt,GET,etc).

			return connection;
		}
		
		
		
		
		private int GetResponseCode(HttpURLConnection connection)
				throws IOException {
			int responseCode = connection.getResponseCode();
			return responseCode;
		}

		
		private Map<String, List<String>> getResponseHeaders(HttpURLConnection connection)
		{
			Map<String, List<String>> map = connection.getHeaderFields();
			return map;
		}
		
		private StringBuffer readInputStream(InputStream inputStream)
				throws IOException {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream), 5000);

			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
			}
			inputStream.close();
			return stringBuffer;
		}
		
		
		public List<String> getReponseHeaderInfo(HttpURLConnection connection,String headerKey)
		{
			List<String> list = new ArrayList<String>();
			Map<String, List<String>> map = connection.getHeaderFields();
			list = map.get(headerKey);		
			return list;
		}
		
		

		public void createPOJOForJSON(String jsonFilePath, String packageName,String className) throws Exception {
			JCodeModel codeModel = new JCodeModel();
			URL source = new File(jsonFilePath).toURI().toURL();
			GenerationConfig config = new DefaultGenerationConfig() {
				@Override
				public boolean isGenerateBuilders() {
					return false;
				}

				@Override
				public boolean isUseCommonsLang3() {
					return true;
				}

				@Override
				public boolean isSerializable() {
					return true;
				}

/*
							@Override
							public Class<? extends RuleFactory> getCustomRuleFactory() {
								return MyRuleFactory.class;
							}*/

				@Override
				public SourceType getSourceType() {
					return SourceType.JSON;
				}

				@Override
				public AnnotationStyle getAnnotationStyle() {
					// TODO Auto-generated method stub
					return AnnotationStyle.GSON;
				}

				@Override
				public Class<? extends Annotator> getCustomAnnotator() {
					return GsonAnnotator.class;
				}

				@Override
				public boolean isIncludeConstructors() {
					return true;
				}

				@Override
				public boolean isIncludeAdditionalProperties() {
					return false;
				}
			};
			SchemaMapper mapper = new SchemaMapper(new RuleFactory(config,
					new GsonAnnotator(config), new SchemaStore()), new SchemaGenerator());
			mapper.generate(codeModel, className, packageName, source);
			codeModel.build(new File("src/test/java"));
		}
		
		/*public void SetHttpsCertificationByPass() {
			try {
				HttpsURLConnection
				.setDefaultHostnameVerifier(new HostnameVerifier() {
					@Override
					public boolean verify(String hostname,
							SSLSession session) {
						return true;
					}

				});

				SSLContext context = SSLContext.getInstance("TLS");
				context.init(null, new X509TrustManager[] { new X509TrustManager() {
					public void checkClientTrusted(X509Certificate[] chain,
							String authType) throws CertificateException {
					}

					public void checkServerTrusted(X509Certificate[] chain,
							String authType) throws CertificateException {
					}

					public X509Certificate[] getAcceptedIssuers() {
						return new X509Certificate[0];
					}
				} }, new SecureRandom());
				HttpsURLConnection.setDefaultSSLSocketFactory(context
						.getSocketFactory());
			} catch (Exception e) { // should never happen
				e.printStackTrace();
			}
		}*/
		
		
		
		
		
		
		
		
		
		
		
		
	}

