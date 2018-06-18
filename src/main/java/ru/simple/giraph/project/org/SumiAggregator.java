/**
 * This is a simple implementation of vertex degree computation.
 */
package ru.simple.giraph.project.org;

import org.apache.giraph.aggregators.BasicAggregator;
import org.apache.giraph.graph.Vertex;
import org.apache.hadoop.io.IntWritable;;

public class SumiAggregator extends BasicAggregator<IntWritable> {

	public void aggregate(IntWritable value) {
		System.out.println("aggregating");
		IntWritable sum = new IntWritable(value.get() + getAggregatedValue().get());
		setAggregatedValue(sum);
		
	}

	public IntWritable createInitialValue() {
		System.out.println("Initializing aggregator");
		return new IntWritable(0);
	}


}
