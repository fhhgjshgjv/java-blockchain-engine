#!/bin/bash
echo "Starting Blockchain Java Node..."
java -jar target/blockchain-java.jar > node.log 2>&1 &
echo "Node started successfully, PID: $!"
