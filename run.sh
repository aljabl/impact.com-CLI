#!/bin/bash

javac -cp lib/picocli-4.7.6.jar ImpactName.java

java -cp .:lib/picocli-4.7.6.jar ImpactName "$@"
