#!/usr/bin/env bash
hadoop jar ./simple-giraph-project-fatjar.jar org.apache.giraph.GiraphRunner \
ru.simple.giraph.project.org.ComputeDegree \
-vif org.apache.giraph.io.formats.IntIntNullTextVertexInputFormat \
-vip example_graph.txt \
-vof org.apache.giraph.io.formats.IdWithValueTextOutputFormat \
-op degrees \
-ca mapreduce.jobtracker.address=localhost:8040 \
-w 1

giraph target/simple-giraph-project-1.0-SNAPSHOT.jar  \
ru.simple.giraph.project.org.ComputeDegree \
-vif org.apache.giraph.io.formats.IntIntNullTextVertexInputFormat \
-vip data/example_graph.txt \
-vof org.apache.giraph.io.formats.IdWithValueTextOutputFormat \
-mc ru.simple.giraph.project.org.DegreeMasterCompute \
-op degrees \
-ca giraph.SplitMasterWorker=false \
-ca giraph.logLevel=ERROR \
-w 1

giraph target/simple-giraph-project-1.0-SNAPSHOT.jar  \
ru.simple.giraph.project.org.SimpleShortestPathsComputation \
-vif org.apache.giraph.io.formats.JsonLongDoubleFloatDoubleVertexInputFormat \
-vip data/shortest_paths_input.txt \
-vof org.apache.giraph.io.formats.IdWithValueTextOutputFormat \
-op degrees \
-ca giraph.SplitMasterWorker=false \
-ca giraph.logLevel=ERROR \
-w 1


giraph target/simple-giraph-project-1.0-SNAPSHOT.jar  \
ru.simple.giraph.project.org.CountingComputation \
-vif org.apache.giraph.io.formats.IntIntNullTextVertexInputFormat \
-vip data/simple_int \
-vof org.apache.giraph.io.formats.IdWithValueTextOutputFormat \
-mc ru.simple.giraph.project.org.SimpleCountingMasterCompute \
-op degrees \
-ca giraph.SplitMasterWorker=false \
-ca giraph.logLevel=ERROR \
-w 1

giraph target/simple-giraph-project-1.0-SNAPSHOT.jar  \
ru.simple.giraph.project.org.OneCountingComputation \
-vif org.apache.giraph.io.formats.IntIntNullTextVertexInputFormat \
-vip data/simple_int \
-vof org.apache.giraph.io.formats.IdWithValueTextOutputFormat \
-mc ru.simple.giraph.project.org.SwitchedCountingMasterCompute \
-op degrees \
-ca giraph.SplitMasterWorker=false \
-ca giraph.logLevel=ERROR \
-w 1

giraph target/simple-giraph-project-1.0-SNAPSHOT.jar  \
ru.simple.giraph.project.org.CountingComputation \
-vif org.apache.giraph.io.formats.IntIntNullTextVertexInputFormat \
-vip data/simple_int_one_vertex \
-vof org.apache.giraph.io.formats.IdWithValueTextOutputFormat \
-mc ru.simple.giraph.project.org.SimpleCountingMasterCompute \
-op degrees \
-ca giraph.SplitMasterWorker=false \
-ca giraph.logLevel=ERROR \
-w 1




