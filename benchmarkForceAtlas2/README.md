# Benchmark

## Install custom gephi-toolkit to maven

Build the custom gephi-toolkit

```
mvn clean install
```

# Customized

Edit this Java Class :

```
<project_path>/src/fr/sciencespo/gephi/toolkit/metrics/LayoutAndMetrics.java
```

# Usage

## GEXF files in the data_input directory

Copy gexf files in the data_input directory.

## Randomize

```
java -jar -Xms256m -Xmx1500m target/gephi-toolkit-metrics-0.0.1-jar-with-dependencies.jar fr.sciencespo.gephi.toolkit.metrics.Main data_input data_output randomize
```

`data_input` specifying where the networks to randomize are, and `data_output` specifying where the new files must be saved.


## Launch

```
cd <project_path>
java -jar -Xms256m -Xmx1500m target/gephi-toolkit-metrics-0.0.1-jar-with-dependencies.jar fr.sciencespo.gephi.toolkit.metrics.Main data_input data_output
```

`data_input` specifying where the networks to benchmark are, and `data_output` specifying where to output the results.