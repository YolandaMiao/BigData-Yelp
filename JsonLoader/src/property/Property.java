
package property;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)


public class Property {
	
		public static class Votes {
		private String funny, useful, cool;
		 
		public String getA() { return funny; }
		public String getB() { return useful; }
		public String getC() { return cool; }
		 
		public void setFirst(String s) { funny = s; }
		public void setMid(String s) { useful = s; }
		public void setLast(String s) { cool = s; }
		}
		
		@JsonProperty("votes")
		private Votes votes;
		@JsonProperty("user_id")
		public String user_id;
		@JsonProperty("review_id")
		public String review_id;
		@JsonProperty("stars")
		public Float stars;
		@JsonProperty("date")
		public String date;
		@JsonProperty("text")
		public String text;
		@JsonProperty("type")
		public String type;
		@JsonProperty("business_id")
		public String business_id;
		
		public Votes getVotes() { return votes; }
		public String getUserId() { return user_id; }
		public String getReviewId() { return review_id; }
		public Float getStars() { return stars; }
		public String getDate() { return date; }
		public String getText() { return text; }
		public String getType() { return type; }
		public String getBusinessId() { return business_id; }
		 
		public void setVotes(Votes v) { votes = v; }
		public void setUserId(String uid) { user_id = uid; }
		public void setReviewId(String rid) { review_id = rid; }
		public void setStars(Float s) { stars = s; }
		public void setDate(String d) { date = d; }
		public void setText(String t) { text = t; }
		public void setType(String ty) { type = ty; }
		public void setBusinessId(String bid) { business_id = bid; }	
}


