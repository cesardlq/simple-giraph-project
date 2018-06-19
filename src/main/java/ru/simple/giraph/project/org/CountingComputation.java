package ru.simple.giraph.project.org;

import java.io.IOException;

import org.apache.giraph.graph.BasicComputation;
import org.apache.giraph.graph.Vertex;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;

public class CountingComputation extends BasicComputation<IntWritable, IntWritable, NullWritable, IntWritable>{
	
	private IntWritable broadcastedValue = new IntWritable(0);
	
	@Override
	public void compute(Vertex<IntWritable, IntWritable, NullWritable> vertex, Iterable<IntWritable> messages)
			throws IOException {
		System.out.println("Broadcasted value at superstep " + getSuperstep() + " in vertex " + vertex.getId() + ": " + getBroadcast("magicNumber"));
		
		
		switch ((int) getSuperstep()) {
			case 0: 
				broadcastedValue = getBroadcast("magicNumber");
				vertex.setValue(new IntWritable(1));
				break;
			case 1:
//				System.out.println("Fake magic number at superstep " + getSuperstep() + ": " + getBroadcast("fakeMagicNumber"));
				vertex.setValue(new IntWritable(2));
				break;
			case 2:
				vertex.setValue(new IntWritable(3));
				System.out.println("Before aggregating at compute");
				aggregate("aggregator", vertex.getValue());
				System.out.println("After aggregating at compute");
				break;
			case 3:
				vertex.voteToHalt();
				break;
		}
		
		System.out.println("Broadcasted value stored in an attribute at superstep " + getSuperstep() + ": " + broadcastedValue);
		//aggregate("aggregator", vertex.getValue());
	}
}
