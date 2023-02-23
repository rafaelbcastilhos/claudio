package ufsc.tcc.cco.server.controller;

import com.squareup.okhttp.*;
import database.Item;
import database.Repository;
import model.Orders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.DatasetMethod;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import utils.DatasetType;
import utils.Headers;

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping(value = "/server", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> server(HttpServletRequest request) throws IOException {
		String method = request.getHeader("method");
		String id = request.getHeader("id");
		System.out.println("method: " + method);

		String bodyString = null;
		byte[] bodyBytes = null;
		Date initDeserialize = null;
		Date endDeserialize = null;
		Orders deserialized = null;
		if (method.equals("JSON") || method.equals("XML")){
			bodyString = request.getReader().lines().reduce("",String::concat);
			initDeserialize = new Date();
			deserialized = new DatasetMethod().deserializeString(method, bodyString);
			endDeserialize = new Date();
		}

		if (method.equals("MSGPACK") || method.equals("KRYO")){
			InputStream is = request.getInputStream();
			bodyBytes = is.readAllBytes();
			initDeserialize = new Date();
			deserialized = new DatasetMethod().deserializeBytes(method, bodyBytes);
			endDeserialize = new Date();
		}
		long timeDeserialize = endDeserialize.getTime() - initDeserialize.getTime();

		Repository.getInstance().create(new Item(
				id,
				method,
				timeDeserialize,
		        "SERVICE"
		));

		return new ResponseEntity<>(new Headers().getHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/client", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> client(HttpServletRequest request) throws IOException {
		String type = request.getHeader("type");
		String size = request.getHeader("size");
		String method = request.getHeader("method");
		String distance = request.getHeader("distance");
		String to = request.getHeader("to");
		String id = UUID.randomUUID().toString();

		Orders obj = new DatasetType().getType(type, size);

		OkHttpClient ok = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody requestBody = null;
		Date initSerialize = null;
		Date endSerialize = null;
		long bytesSerialize = 0;
		if (method.equals("JSON") || method.equals("XML")){
			initSerialize = new Date();
			String serialized = new DatasetMethod().serializeString(method, obj).toString();
			System.out.println("serialize: " + serialized);
			endSerialize = new Date();
			bytesSerialize = serialized.getBytes().length;
			requestBody = RequestBody.create(mediaType, serialized);
		}

		if (method.equals("MSGPACK") || method.equals("KRYO")){
			initSerialize = new Date();
			byte[] serialized = new DatasetMethod().serializeBytes(method, obj);
			System.out.println("serialize: " + Arrays.toString(serialized));
			endSerialize = new Date();
			bytesSerialize = serialized.length;
			requestBody = RequestBody.create(mediaType, serialized);
		}
		Request requestClient = new Request.Builder()
				.url(to)
				.method("POST", requestBody)
				.addHeader("method", method)
				.addHeader("id", id)
				.build();

		System.out.println("request: " + request);

		Date initRequest = new Date();
		Response response = ok.newCall(requestClient).execute();
		Date endRequest = new Date();
		long timeSerialize = endSerialize.getTime() - initSerialize.getTime();
		long timeRequest = endRequest.getTime() - initRequest.getTime();
		System.out.println("response: " + response.code());

		Item item = Repository.getInstance().get(id);
		item.setType(type);
		item.setSize(size);
		item.setDistance(distance);
		item.setTimeSerialize(timeSerialize);
		item.setTimeRequest(timeRequest);
		Repository.getInstance().update(item);

		return new ResponseEntity<>(new Headers().getHeaders(), HttpStatus.OK);
	}
}
