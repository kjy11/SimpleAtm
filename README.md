# Clone

```shell
git clone https://github.com/kjy11/SimpleAtm.git
```

# Java Version
Java 11

# Build

```shell
./gradlew build
```

# Run Tests

```shell
./gradlew test
```

Test output is in `./build/test-results/test` and `./build/reports/tests/test`.

# Methods
The methods another engineer need to use for the UI implementation are in `./src/main/java/atm/AtmController.java`

- checkPin
- getAccounts
- getBalance
- deposit
- withdraw