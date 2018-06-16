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
		if (getSuperstep() == 0) {
			broadcast("magicNumber", null);
		}
	}

	@Override
	public void initialize() throws InstantiationException, IllegalAccessException {
		//broadcast("magicNumber", new IntWritable(-1));
		
	}

}
