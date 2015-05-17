import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Wordmapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable> {

	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, IntWritable> Output, Reporter r)
			throws IOException {
	String s=value.toString();
	for(String word:s.split(" "))
	{
		if(word.length() > 0)
		{
			Output.collect(new Text(word), new IntWritable(1));			
		}
	}
		
	}

}
