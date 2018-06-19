package ru.simple.giraph.project.org;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.giraph.master.MasterCompute;
import org.apache.hadoop.io.IntWritable;

public class SimpleCountingMasterCompute extends MasterCompute {

	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void compute() {
		System.out.println("\n\n Superstep: " + getSuperstep());
		System.out.println("Aggregated value: " + getAggregatedValue("aggregator"));
		if (getSuperstep() == 0) {
			//broadcast("magicNumber", null);
			broadcast("magicNumber", new IntWritable(-1));
		}
	}

	@Override
	public void initialize() throws InstantiationException, IllegalAccessException {
		//broadcast("magicNumber", new IntWritable(-1));
		registerPersistentAggregator("aggregator", SumiAggregator.class);
		
	}

}
