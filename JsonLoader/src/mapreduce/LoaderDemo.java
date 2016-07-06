package mapreduce;

import java.io.IOException;
import java.io.StringReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;


import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import parser.*;
import property.Property;



public class LoaderDemo {
	public static class JsonMapper extends Mapper<Object, Text, Text, Text> {
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			try{
				//JSONObject jsn = new JSONObject(value.toString());
				Gson gsn = new Gson();
				StringReader reader = new StringReader(value.toString());
				JsonReader jsnreader = new JsonReader(reader);
				
				jsnreader.setLenient(true);
				Property property = gsn.fromJson(jsnreader, Property.class);
				
				Text review_id = new Text(property.review_id);
				Text vote_info = new Text(property.text +" funny is " + property.getVotes().getA()+ " useful is " + property.getVotes().getB() + " cool is " + property.getVotes().getC());
				
				context.write(review_id,vote_info);
			}
			catch (JSONException e) {
				// TODO Auto-generated catch block
	            e.printStackTrace();
			}
		}
		  
	}

	/*
	public static class JsonReducer extends Reducer<Text, InfoWritable, Text, Text>{
		
	}
	*/
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		runJob(args[0], args[1]);
	}
	
	public static void runJob(String input, String output) throws Exception {
		Configuration conf = new Configuration();
		Job job = new Job(conf);
		job.setJarByClass(LoaderDemo.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		job.setMapperClass(JsonMapper.class);
		job.setNumReduceTasks(0);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		// set arguments of input and output path
		Path inPath = new Path(input);
		FileInputFormat.setInputPaths(job, inPath);
		Path outPath = new Path(output);
		FileOutputFormat.setOutputPath(job, outPath);
		
		outPath.getFileSystem(conf).delete(outPath,true);
		
		job.waitForCompletion(true);
		
	}

}
