# Java Blockchain Engine
A high-performance, modular blockchain development engine based on Java, supporting distributed P2P networks, smart contracts, transaction verification, wallet management, and secure consensus mechanisms.

## Project Overview
This project provides a full-featured blockchain infrastructure for decentralized application development, chain deployment, transaction processing, and node management. It includes core chain structures, network communication, smart contract execution, data persistence, API services, and operation tools.

## Included Files & Functions
1. **BlockchainCore.java** - Core blockchain engine, implements block creation, mining, chain validation, and hash calculation
2. **Block.java** - Block entity definition, stores block data, hash, timestamp and mining logic
3. **WalletManager.java** - Digital wallet management, key pair generation and balance tracking
4. **TransactionSigner.java** - Transaction signature and verification module
5. **P2PNetworkNode.java** - P2P distributed network node, supports peer connection and message broadcasting
6. **SmartContractExecutor.java** - Smart contract runtime and execution engine
7. **ContractFunction.java** - Smart contract function interface definition
8. **ChainConsensus.java** - Consensus layer implementation, longest chain validation and selection
9. **TransactionPool.java** - Pending transaction pool management
10. **Transaction.java** - Transaction entity and validation rules
11. **ChainDataStorage.java** - Blockchain persistent storage and file read/write
12. **NodeMonitorService.java** - Real-time node status monitoring service
13. **MiningScheduler.java** - Automatic mining scheduling service
14. **AddressGenerator.java** - Blockchain wallet address generation tool
15. **ChainAPIServer.java** - HTTP API service for blockchain interaction
16. **ChainHandler.java** - API request handler for chain status queries
17. **MineHandler.java** - API mining request controller
18. **ChainSyncService.java** - Cross-node chain data synchronization
19. **TokenContractLogic.java** - Custom token contract logic implementation
20. **ChainValidatorTool.java** - Full-chain and single-block verification tool
21. **config.json** - JSON format node and blockchain configuration
22. **log4j2.xml** - Log configuration file
23. **application.properties** - Project runtime properties
24. **Dockerfile** - Containerized deployment configuration
25. **start.sh** - Node one-click startup script

## Features
- Complete blockchain structure and mining system
- ECDSA asymmetric encryption transaction signature
- P2P distributed node communication
- Smart contract virtual machine
- Multi-node consensus and chain synchronization
- RESTful API service
- Persistent data storage
- Containerized deployment support
- Real-time monitoring and automatic scheduling

## Usage
Deploy the node, start the P2P network, create wallets, send transactions, deploy smart contracts, and manage the chain through APIs or command line.
