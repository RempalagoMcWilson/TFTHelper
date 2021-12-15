package util;

public class Util {

	public static String resCodeToText(String code) {
		switch (code) {
		case "400":
			return "Bad request";
		case "401":
			return "Unauthorized";
		case "403":
			return "Forbidden";
		case "404":
			return "Data not found";
		case "405":
			return "Method not allowed";
		case "415":
			return "Unsupported media type";
		case "429":
			return "Rate limit exceeded";
		case "500":
			return "Internal server error";
		case "502":
			return "Bad gateway";
		case "503":
			return "Service unavailable";
		case "504":
			return "Bad request";
		default:
			return "Gateway timeout";
		}
	}
}
