package ru.simple.giraph.project.org;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.apache.giraph.master.MasterCompute;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Writable;



public class DegreeMasterCompute extends MasterCompute {
	
	private int numberito = 5;

	

	@Override
	public void compute() {
		
		
		
		
		switch((int)getSuperstep() ){
			//**DELETE OPERATION
			case 0:
				numberito += 3;
				System.out.println("Numberito superstep: " + getSuperstep() + " :" +  numberito);
				break;
			case 1:
				numberito += 4;
				System.out.println("Numberito superstep: " + getSuperstep() + " :" +  numberito);
				break;


		}
	}

	@Override
	public void initialize() throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		
	}


	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}


	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}