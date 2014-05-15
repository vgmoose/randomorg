randomorg
=========

Random generator via atmospheric noise [Random.org](http://random.org)

This version includes a User-Agent modification.

**Current version:** 0.2

### Getting started

**Integer Generator**

``` java
// generate two 6-side dice rolls
IntegerGenerator ig = new IntegerGenerator();
ArrayList<Integer> numbers = ig.generate(1,6,2)
```

**Double Generator**

``` java
// generate 27 doubles between 0 and 1
DoubleGenerator dg = new DoubleGenerator();
ArrayList<Double> doubles = dg.generate(27)
```

**Sequence Generator**

``` java
// shuffle 52-card deck
SequenceGenerator sg = new SequenceGenerator();
ArrayList<Integer> numbers = sg.generate(1, 52);
```

**String Generator**

``` java
// new password alphanumeric 12 chars
StringGenerator strg = new StringGenerator();
ArrayList<String> numbers = strg.generate(12, 1, true, true, true, true);
```

**Quota Checker**

``` java
// check your remaining quota
QuotaChecker qc = new QuotaChecker();
long quota = qc.quota();
```

### Implementation

All work with HTTP GET API happens in **HTTPUtils** util class. As we do not know
return type for concrete GET-request yet we return `ArrayList<String>` which
further can be processed by responsible methods.

All successful requests have response code 200.
In case server returns 503 response code, IOException is thrown and should be
handled on client side.

### Build

`gradle build`