package ru.simple.giraph.project.org;

import java.io.IOException;

import org.apache.giraph.graph.BasicComputation;
import org.apache.giraph.graph.Vertex;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;

public class CountingComputation extends BasicComputation<IntWritable, IntWritable, NullWritable, IntWritable>{

	@Override
	public void compute(Vertex<IntWritable, IntWritable, NullWritable> vertex, Iterable<IntWritable> messages)
			throws IOException {
		System.out.println("Magic number at superstep " + getSuperstep() + ": " + getBroadcast("magicNumber"));
		
		switch ((int) getSuperstep()) {
			case 0: 
				vertex.setValue(new IntWritable(1));
				break;
			case 1:
				System.out.println("Fake magic number at superstep " + getSuperstep() + ": " + getBroadcast("fakeMagicNumber"));
				vertex.setValue(new IntWritable(2));
				break;
			case 2:
				vertex.setValue(new IntWritable(3));
				break;
			case 3:
				vertex.voteToHalt();
				break;
		}
	}
}
